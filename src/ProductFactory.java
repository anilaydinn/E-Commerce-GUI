
public class ProductFactory {
	public IProducts getProduct(String productType) {
		
		if(productType == null) {
			return null;
		}
		
		if(productType.equalsIgnoreCase("CAR")) {
			return new Car();
		}
		else if(productType.equalsIgnoreCase("PHONE")) {
			return new Phone();
		}
		else if(productType.equalsIgnoreCase("COMPUTER")) {
			return new Computer();
		}
		return null;
	}
}
