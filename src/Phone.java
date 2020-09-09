
public class Phone extends Product implements IProducts {
	
	private String ram;
	private int screenSize;
	private boolean isDoubleSim;
	private String processor;
	
	public Phone(String brand, String model, double price, String ram, int screenSize, boolean isDoubleSim, String processor) {
		super(brand, model, price);
		this.ram = ram;
		this.screenSize = screenSize;
		this.isDoubleSim = isDoubleSim;
		this.processor = processor;
	}
	
	public Phone() {}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public boolean isDoubleSim() {
		return isDoubleSim;
	}

	public void setDoubleSim(boolean isDoubleSim) {
		this.isDoubleSim = isDoubleSim;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Override
	public String writeInformation() {
		return getBrand() + " " + getModel() + " " + getPrice() + " " + this.processor + " " + this.ram + " " + this.screenSize;
	}
	
}
