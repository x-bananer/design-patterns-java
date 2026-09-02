package composite;

public class Employee extends Component {
	private double salary;

	public Employee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	@Override
	public void add(Component component) {
		throw new UnsupportedOperationException("Not supported for employee.");
	}
 
	@Override
	public void remove(Component component) {
        throw new UnsupportedOperationException("Not supported for employee.");
    }

	@Override
	public double getSalary() {
        return this.salary;
    }

	@Override
	public void printXML() {
		System.out.println("<employee name=\"" + name + "\" salary=\"" + salary + "\" />");
	}
}
