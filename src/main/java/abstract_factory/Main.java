package abstract_factory;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Choose an interface style:");
		System.out.println("1 - Square UI");
		System.out.println("2 - Round UI");
		System.out.println("");
		System.out.println("Enter any key to exit");

		String choice = scanner.nextLine().trim().toLowerCase();

		UIFactory factory;

		if (choice.equals("1")) {
			factory = new SquareFactory();
		} else if (choice.equals("2")) {
			factory = new RoundFactory();
		} else {
			return;
		}

		Button button = factory.createButton("Save");
		TextField textField = factory.createTextField("Enter email...");
		Checkbox checkbox = factory.createCheckbox("Keep me signed in");

		button.display();
		checkbox.display();
		textField.display();

		System.out.println("");
		System.out.println("Changing UI texts...");
		System.out.println("");

		button.setText("Cancel");
		checkbox.setText("Enter password...");
		textField.setText("Accept terms and conditions");

		button.display();
		checkbox.display();
		textField.display();

	}
}
