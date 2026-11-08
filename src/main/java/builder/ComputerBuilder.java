package builder;

public interface ComputerBuilder {
	void buildProcessor();
	void buildRAM();
	void buildHardDrive();
	void buildGraphicsCard();
	void buildOperatingSystem();
	void addAccessory(String name);
	Computer getComputer();
}
