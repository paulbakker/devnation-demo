package webshop.products.api;

import java.util.List;

public interface ProductService {
	List<Product> listProducts(String category);
}
