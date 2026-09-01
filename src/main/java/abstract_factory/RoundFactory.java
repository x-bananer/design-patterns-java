package abstract_factory;

public class RoundFactory extends UIFactory {
	@Override
	public Button createButton(String text) {
		return new ButtonRound(text);
	}

	@Override
	public Checkbox createCheckbox(String text) {
		return new CheckboxRound(text);
	}

	@Override
	public TextField createTextField(String text) {
		return new TextFieldRound(text);
	}
}
