package composite;

public class Main {
	public static void main(String[] args) {
		Department metropolia = new Department("Metropolia");

		Department ict = new Department("ICT");
		Department business = new Department("Business");

		Employee anna = new Employee("Anna", 3000);
		Employee sofia = new Employee("Sofia", 4000);
		Employee maria = new Employee("Maria", 3500);

		ict.add(anna);
		ict.add(sofia);
		business.add(maria);

		metropolia.add(ict);
		metropolia.add(business);

		System.out.println("Total salary expenses: " + metropolia.getSalary());

		metropolia.printXML();

		ict.remove(anna);

		System.out.println("Anna quit");
		System.out.println("Total salary expenses: " + metropolia.getSalary());

		metropolia.printXML();
	}
}
