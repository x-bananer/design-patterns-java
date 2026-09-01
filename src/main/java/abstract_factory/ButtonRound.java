package abstract_factory;

public class ButtonRound extends Button {
	public ButtonRound(String text) {
		super(text);
	}

	@Override
	public void display() {
		System.out.println("( " + text + " )");
	}
}
