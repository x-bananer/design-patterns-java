package memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	private Model model;
	private Gui gui;
	private List<IMemento> undoHistory; // Memento history
	private List<IMemento> redoHistory; // REDO: redo history ArrayList
	private List<IMemento> history; // HISTORY WINDOW: saved states ArrayList

	public Controller(Gui gui) {
		this.model = new Model();
		this.gui = gui;
		this.undoHistory = new ArrayList<>();
		this.redoHistory = new ArrayList<>(); // REDO: redo history ArrayList init
		this.history = new ArrayList<>(); // HISTORY WINDOW: saved states ArrayList init
		this.history.add(model.createMemento()); // Save the initial state
	}

	public void setOption(int optionNumber, int choice) {
		saveToHistory();
		model.setOption(optionNumber, choice);
		updateHistoryWindow();
	}

	public int getOption(int optionNumber) {
		return model.getOption(optionNumber);
	}

	public void setIsSelected(boolean isSelected) {
		saveToHistory();
		model.setIsSelected(isSelected);
		updateHistoryWindow();
	}

	public boolean getIsSelected() {
		return model.getIsSelected();
	}

	public List<IMemento> getHistory() { // HISTORY WINDOW: return the saved states
		return new ArrayList<>(history);
	}

	public void undo() {
		if (!undoHistory.isEmpty()) {
			System.out.println("Memento found in history");

			redoHistory.add(model.createMemento()); // REDO: saves the current state so it can be restored

			IMemento previousState = undoHistory.remove(undoHistory.size() - 1);
			model.restoreState(previousState);
			gui.updateGui();
		}
	}

	public void redo() { // REDO: restore the last undone state
		if (!redoHistory.isEmpty()) { // Checks if there is a state to restore
			undoHistory.add(model.createMemento()); // Saves the current state in undoHistory so the change can be undone again
			IMemento nextState = redoHistory.remove(redoHistory.size() - 1); // Takes the last state from redoHistory
			model.restoreState(nextState); // and restores it
			gui.updateGui(); // Updates the user interface
		}
	}

	private void saveToHistory() {
		redoHistory.clear(); // REDO: clear redo history when the user makes a new change

		IMemento currentState = model.createMemento();
		undoHistory.add(currentState);
	}

	private void updateHistoryWindow() {
		history.add(model.createMemento());
		if (history.size() > 10) { // HISTORY WINDOW: keep only the 10 most recent states
			history.remove(0); // HISTORY WINDOW: remove the oldest state
		} // HISTORY WINDOW
		gui.updateHistory();
	}

	// HISTORY WINDOW: restore selected state
	public void restoreFromHistory(IMemento state) {
		// Save the current state so the selection can be undone
		undoHistory.add(model.createMemento());

		// Clear redo history because a different state was selected
		redoHistory.clear();
	
		model.restoreState(state);
		gui.updateGui();
	}
}
