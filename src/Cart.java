import java.util.ArrayList;

public class Cart {

	private ArrayList<Product> cart = new ArrayList<Product>();
	
	public Cart(ArrayList<Product> cart){
		this.cart = cart;
	}
	
	public Cart() {}
	
	public void addProduct(Product product) {
		cart.add(product);
	}
	
	public ArrayList<Product> listProduct(){
		return this.cart;
	}
}
