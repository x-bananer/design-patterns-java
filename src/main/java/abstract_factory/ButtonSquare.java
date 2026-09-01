package abstract_factory;

public class ButtonSquare extends Button {
	public ButtonSquare(String text) {
		super(text);
	}

	@Override
	public void display() {
		System.out.println("[ " + text + " ]");
	}
}
