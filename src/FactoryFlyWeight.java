import java.util.HashMap;

public class FactoryFlyWeight {
	
	public static int product = 1;
	public static int user = 2;
	
	private static HashMap<Integer, ProductFactory> map = new HashMap<Integer, ProductFactory>();
	
	public static ProductFactory createFactory(int number) {
		
		ProductFactory factory = null;
		
		switch(number) {
		case 1:
			factory = map.get(number);
		
			if(factory == null) {
				factory = new ProductFactory();
				map.put(number,factory);
			}
			break;
		}
		return factory;
	}
}
