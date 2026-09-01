package abstract_factory;

public class SquareFactory extends UIFactory {
	@Override
	public Button createButton(String text) {
		return new ButtonSquare(text);
	}

	@Override
	public Checkbox createCheckbox(String text) {
		return new CheckboxSquare(text);
	}

	@Override
	public TextField createTextField(String text) {
		return new TextFieldSquare(text);
	}
}
