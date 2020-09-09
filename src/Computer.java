
public class Computer extends Product {
	private String ram;
	private String graphicCard;
	private String processor;
	private String operatingSystem;
	
	public Computer(double price, String brand, String model, String ram, String graphicCard, String processor,String operatingSystem) {
		super(brand,model,price);
		this.ram = ram;
		this.graphicCard = graphicCard;
		this.processor = processor;
		this.operatingSystem = operatingSystem;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getGraphicCard() {
		return graphicCard;
	}

	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	
	
}
