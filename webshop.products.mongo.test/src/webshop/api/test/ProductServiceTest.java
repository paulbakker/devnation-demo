package webshop.api.test;

import java.util.List;
import java.util.Properties;

import org.amdatu.bndtools.test.BaseOSGiServiceTest;

import webshop.products.api.Product;
import webshop.products.api.ProductService;

public class ProductServiceTest extends BaseOSGiServiceTest<ProductService>{

	public ProductServiceTest() {
		super(ProductService.class);
	}
	
	@Override
	public void setUp() throws Exception {
		
		Properties props = new Properties();
		props.put("dbName", "osgiwebshop");
		
		configureFactory("org.amdatu.mongo", props);
		
		super.setUp();
	}
	
	public void testList() {
		List<Product> listProducts = instance.listProducts("Games");
		assertEquals(3, listProducts.size());
	}
}