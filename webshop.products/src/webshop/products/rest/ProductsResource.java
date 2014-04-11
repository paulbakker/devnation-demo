package webshop.products.rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;

import webshop.products.api.Product;
import webshop.products.api.ProductService;


@Path("products")
@Component(provides=Object.class)
public class ProductsResource {

	@ServiceDependency(required=false)
	private volatile ProductService productService;
	
	
	@GET
	@Path("categories")
	public List<String> listCategories() {
		return Arrays.asList("Books", "Games");
	}
	
	@GET
	@Path("{category}")
	public List<Product> listProducts(@PathParam("category") String category) {
		return productService.listProducts(category);
	}
}
