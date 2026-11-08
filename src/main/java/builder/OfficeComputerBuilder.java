package builder;

public class OfficeComputerBuilder implements ComputerBuilder {
	private Computer computer;

	public OfficeComputerBuilder() {
		this.computer = new Computer();
	}

	@Override
	public void buildProcessor() {
		computer.addComponent(new Component("Processor: Intel Core i3-12100"));
	}

	@Override
	public void buildRAM() {
		computer.addComponent(new Component("RAM: 8 GB"));
	}

	@Override
	public void buildHardDrive() {
		computer.addComponent(new Component("Hard drive: 256 GB SSD"));
	}

	@Override
	public void buildGraphicsCard() {
		computer.addComponent(new Component("Graphics card: Integrated Intel UHD Graphics"));
	}

	@Override
	public void buildOperatingSystem() {
		computer.addComponent(new Component("Operating system: Windows 11 Pro"));
	}

	@Override
	public Computer getComputer() {
		return this.computer;
	}
}
