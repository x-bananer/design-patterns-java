package builder;

public class GamingComputerBuilder implements ComputerBuilder {
	private Computer computer;

	public GamingComputerBuilder() {
		this.computer = new Computer();
	}

	@Override
	public void buildProcessor() {
		computer.addComponent(new Component("Processor: Intel Core i7-14700K"));
	}

	@Override
	public void buildRAM() {
		computer.addComponent(new Component("RAM: 32 GB"));
	}

	@Override
	public void buildHardDrive() {
		computer.addComponent(new Component("Hard drive: 2 TB NVMe SSD"));
	}

	@Override
	public void buildGraphicsCard() {
		computer.addComponent(new Component("Graphics card: NVIDIA GeForce RTX 4070"));
	}

	@Override
	public void buildOperatingSystem() {
		computer.addComponent(new Component("Operating system: Windows 11 Home"));
	}

	@Override
	public Computer getComputer() {
		return this.computer;
	}
}
