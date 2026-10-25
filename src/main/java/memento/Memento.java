package memento;

import java.time.LocalDateTime;

public class Memento implements IMemento {
	private int[] options;
	private boolean isSelected;
	private LocalDateTime createdAt; // HISTORY WINDOW: 

	public Memento(int[] options, boolean isSelected) {
		this.options = options.clone(); // Copy options array
		this.isSelected = isSelected;
		System.out.println("Memento created");
		this.createdAt = LocalDateTime.now(); // HISTORY WINDOW: 
	}

	public int[] getOptions() {
		return options;
	}

	public boolean isSelected() {
		return isSelected;
	}

	@Override
	public LocalDateTime getCreatedAt() { // HISTORY WINDOW: 
		return createdAt;
	}
}