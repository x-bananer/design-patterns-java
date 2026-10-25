# Memento

## Improved history functionality
 
There is a graphical user interface that contains three colored rectangles and one checkbox. The user can change the colors as well as the status of the checkbox, and the state of the model is updated accordingly. The application uses the Memento pattern to save and restore the state of the model. The undo functionality is triggered by the user pressing the Ctrl+Z key combination.

The goal is to add two features to the application:

- Redo functionality: The user can press the Ctrl+Y key combination to redo the last undone action.
- History window: The application opens a new window that displays the history of the model's state changes. The history window contains a list of the states of the model, and the user can select a state from the list to restore the model to that state.

Source assignment: [https://github.com/vesavvo/design_patterns/blob/master/markdown/assignments/memento.md](https://github.com/vesavvo/design_patterns/blob/master/markdown/assignments/memento.md)

## Start application

```sh
mvn org.openjfx:javafx-maven-plugin:0.0.8:run -Djavafx.mainClass=memento.Main
```