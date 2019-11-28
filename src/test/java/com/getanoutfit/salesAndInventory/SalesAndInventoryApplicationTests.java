package com.getanoutfit.salesAndInventory;

import com.getanoutfit.salesAndInventory.Product.ProductDto;
import com.getanoutfit.salesAndInventory.Mapper.MapperBuilder;
import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.Product.ProductService;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalesAndInventoryApplicationTests {

	@Autowired
	ProductCategoryService productCategoryService;
	@Autowired
	ProductService productService;
	@Test
	void contextLoads() {
//		Product product= new Product();
//		ProductCategory productCategory = new ProductCategory();
//		productCategory.setId(1);
//		productCategory.setCategoryName("test Name");
//
//		product.setProdName("test");
//		product.setProdDescription("test");
//		product.setProdPrice(12);
//		product.setProductCategory(productCategory);
////		new ProductDto("test", "test", "12");
//		ProductDto productDto= MapperBuilder.INSTANCE.productToProductDto(product);
//		System.out.println("test is "+productDto.toString());
//		System.out.println("test is "+product.toString());
//		System.out.println(product.equals(productDto));
	}

	@Test
	void testDeleteOperaiton(){
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(1);
		productCategory.setCategoryName("test category");

		productCategoryService.save(productCategory);

		Product product = new Product();
		product.setProductCategory(productCategory);
		product.setId(1);
		product.setProdName("rambo");
		product.setProdPrice(2500);
		product.setProdId(1);
		product.setProdQuantity(2);

		productService.save(product);

		productCategoryService.deleteById(1);

	}

}
