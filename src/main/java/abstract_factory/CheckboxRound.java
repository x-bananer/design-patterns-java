package abstract_factory;

public class CheckboxRound extends Checkbox {
	public CheckboxRound(String text) {
		super(text);
	}

	@Override
	public void display() {
		System.out.println("(x) " + text);
	}
}
