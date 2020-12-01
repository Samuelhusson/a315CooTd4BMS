package rental;

import java.util.ArrayList;
import java.util.List;

public class Trip{

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
    
    public double getPrice() {
    	double cheap = -1;
    	for (Product p : products) {
    		if (cheap == -1 || cheap > p.getPrice()) {
    			cheap = p.getPrice();
    		}
    	}
    	return cheap;
    }
    
    @Override
    public String toString() {
    	return "Informations sur le trip souhaité :\n"+desc+"\n"+"Voyage proposés : \n"+products;
    }
}
