package builder;

public class Main {
	public static void main(String[] args) {
		ComputerDirector director = new ComputerDirector();
		

		ComputerBuilder officeBuilder = new OfficeComputerBuilder();
		director.setBuilder(officeBuilder);
		director.constructComputer();

		officeBuilder.addAccessory("Monitor");
		officeBuilder.addAccessory("Mouse");

		System.out.println("Office computer:");
		System.out.println(officeBuilder.getComputer());


		ComputerBuilder gamingBuilder = new GamingComputerBuilder();
		director.setBuilder(gamingBuilder);
		director.constructComputer();

		gamingBuilder.addAccessory("Keyboard");
		gamingBuilder.addAccessory("Headset");

		System.out.println("Gaming computer:");
		System.out.println(gamingBuilder.getComputer());
	}
}