package abstract_factory;

public abstract class UiElement {
	String text;

	UiElement(String text) {
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public abstract void display();
}
