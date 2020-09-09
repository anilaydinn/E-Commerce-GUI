import java.util.ArrayList;

public class Cart {

	private ArrayList<Product> cart;
	
	public Cart(ArrayList<Product> cart){
		this.cart = cart;
	}
	
	public void addProduct(Product product) {
		cart.add(product);
	}
}
