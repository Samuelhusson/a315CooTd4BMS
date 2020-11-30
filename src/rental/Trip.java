package rental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Trip implements Product{

    protected Description desc;
    private List<Product> products;

    public Trip(Description description) {
        desc = description;
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }
    
    public void setProducts(List<Product> prod) {
    	products = prod;
    }
    
    public void addItem(Product prod) {
    	products.add(prod);
    }

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
}
