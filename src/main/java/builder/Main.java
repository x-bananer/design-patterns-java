package builder;

public class Main {
	public static void main(String[] args) {
		ComputerDirector director = new ComputerDirector();
		

		ComputerBuilder officeBuilder = new OfficeComputerBuilder();
		director.setBuilder(officeBuilder);
		director.constructComputer();

		System.out.println("Office computer:");
		System.out.println(officeBuilder.getComputer());


		ComputerBuilder gamingBuilder = new GamingComputerBuilder();
		director.setBuilder(gamingBuilder);
		director.constructComputer();

		System.out.println("Gaming computer:");
		System.out.println(gamingBuilder.getComputer());
	}
}