package abstract_factory;

public class TextFieldRound extends TextField {
	public TextFieldRound(String text) {
		super(text);
	}

	@Override
	public void display() {
		System.out.println("(( " + text + " ))");
	}
}
