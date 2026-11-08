package builder;

public class ComputerDirector {
	private ComputerBuilder builder;

	public void setBuilder(ComputerBuilder builder) {
		this.builder = builder;
	}

	public void constructComputer() {
		builder.buildProcessor();
		builder.buildRAM();
		builder.buildHardDrive();
		builder.buildGraphicsCard();
		builder.buildOperatingSystem();
	}
}
