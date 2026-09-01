package abstract_factory;

public class CheckboxSquare extends Checkbox {
	public CheckboxSquare(String text) {
		super(text);
	}

	@Override
	public void display() {
		System.out.println("[x] " + text);
	}
}
