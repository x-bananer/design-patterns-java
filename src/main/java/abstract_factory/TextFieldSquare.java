package abstract_factory;

public class TextFieldSquare extends TextField {
	public TextFieldSquare(String text) {
		super(text);
	}

	@Override
	public void display() {
		System.out.println("[[ " + text + " ]]");
	}
}
