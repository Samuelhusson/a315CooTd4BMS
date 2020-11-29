package rental;

import java.util.Collection;
import java.util.List;

public class Trip {

    private Description desc;
    private List<Product> products;

    public Trip(Description description) {
        desc = description;
    }

    public List<Product> getProducts() {
        return products;
    }
}
