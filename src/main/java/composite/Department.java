package composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends Component {
	private List<Component> children = new ArrayList<>();

	public Department(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		this.children.add(component);
	}

	@Override
	public void remove(Component component) {
		this.children.remove(component);
	}

	@Override
	public double getSalary() {
		double totalSalary = 0;

		for (Component child : children) {
			totalSalary += child.getSalary();
		}

		return totalSalary;
	}

	@Override
	public void printXML() {
		System.out.println("<department name=\"" + name + "\">");

		for (Component child : children) {
			child.printXML();
		}

		System.out.println("</department>");
	}
}
