package memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.control.ListView;
import java.time.format.DateTimeFormatter; // HISTORY WINDOW

public class Gui extends Application {

	// create a GUI with three adjacent ColorBoxes and one CheckBox below them
	private Controller controller;
	private ColorBox colorBox1;
	private ColorBox colorBox2;
	private ColorBox colorBox3;
	private CheckBox checkBox;
	private ListView<IMemento> historyList; // HISTORY WINDOW

	public void start(Stage stage) {

		controller = new Controller(this);

		// HISTORY WINDOW: create a window with a list of saved states
		historyList = new ListView<>();
		updateHistory();

		// HISTORY WINDOW: restore the state selected by the user
		historyList.setOnMouseClicked(event -> {
			IMemento selectedState = historyList.getSelectionModel().getSelectedItem();

			if (selectedState != null) {
				controller.restoreFromHistory(selectedState);
			}
		});

		historyList.setCellFactory(list -> new javafx.scene.control.ListCell<>() {
			@Override
			protected void updateItem(IMemento state, boolean empty) {
				super.updateItem(state, empty);

				if (empty || state == null) {
					setText(null);
				} else {
					setText(state.getCreatedAt().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))); // HISTORY WINDOW: format date and time
				}
			}
		});

		Stage historyStage = new Stage();
		historyStage.initOwner(stage);
		historyStage.setTitle("History");
		historyStage.setScene(new Scene(historyList, 300, 500));
		historyStage.show();

		// Insets for margin and padding
		Insets insets = new Insets(10, 10, 10, 10);

		// Create three ColorBoxes
		colorBox1 = new ColorBox(1, controller);
		colorBox2 = new ColorBox(2, controller);
		colorBox3 = new ColorBox(3, controller);

		// Create a CheckBox
		checkBox = new CheckBox("Click me!");
		checkBox.setPadding(insets);

		// Add the ColorBoxes and CheckBox to a HBox
		HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
		hBox.setSpacing(10);

		hBox.setMargin(colorBox1.getRectangle(), insets);
		hBox.setMargin(colorBox2.getRectangle(), insets);
		hBox.setMargin(colorBox3.getRectangle(), insets);

		Label label = new Label("Press Ctrl-Z to undo the last change.");
		label.setPadding(insets);

		// create a VBox that contains the HBox and the CheckBox
		VBox vBox = new VBox(hBox, checkBox, label);
		// call controller when the CheckBox is clicked
		checkBox.setOnAction(event -> {
			controller.setIsSelected(checkBox.isSelected());
		});

		// Set the HBox to be the root of the Scene
		Scene scene = new Scene(vBox);
		scene.setOnKeyPressed(event -> {
			if (event.isControlDown() && event.getCode() == KeyCode.Z) {
				// Ctrl-Z: undo
				System.out.println("Undo key combination pressed");
				controller.undo();
			}

			if (event.isControlDown() && event.getCode() == KeyCode.Y) { // REDO: restore last change when user presses
																			// Ctrl-Y
				// Ctrl-Y: redo
				System.out.println("Redo key combination pressed");
				controller.redo();
			}
		});

		stage.setScene(scene);
		stage.setTitle("Memento Pattern Example");
		stage.show();
	}

	// HISTORY WINDOW: update list of saved states
	public void updateHistory() {
		historyList.getItems().setAll(controller.getHistory());
	}

	public void updateGui() {
		// called after restoring state from a Memento
		colorBox1.setColor(controller.getOption(1));
		colorBox2.setColor(controller.getOption(2));
		colorBox3.setColor(controller.getOption(3));
		checkBox.setSelected(controller.getIsSelected());
	}
}
