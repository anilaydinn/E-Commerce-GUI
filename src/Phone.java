
public class Phone extends Product {
	
	private int ram;
	private int screenSize;
	private boolean isDoubleSim;
	private String processor;
	
	public Phone(String brand, String model, double price, int ram, int screenSize, boolean isDoubleSim, String processor) {
		super(brand, model, price);
		this.ram = ram;
		this.screenSize = screenSize;
		this.isDoubleSim = isDoubleSim;
		this.processor = processor;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
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
}
