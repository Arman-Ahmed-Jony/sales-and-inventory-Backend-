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

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        product1.setProductCategory(productCategory);
		product1.setId(1);
		product1.setProdName("rambo");
		product1.setProdPrice(2500);
		product1.setProdId(1);
		product1.setProdQuantity(2);

        product2.setProductCategory(productCategory);
        product2.setId(2);
        product2.setProdName("rambo");
        product2.setProdPrice(2500);
        product2.setProdId(2);
        product2.setProdQuantity(2);


        product3.setProductCategory(productCategory);
        product3.setId(3);
        product3.setProdName("rambo");
        product3.setProdPrice(2500);
        product3.setProdId(3);
        product3.setProdQuantity(2);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
		productService.deleteByProductCategory(productCategory.getId());
		productCategoryService.deleteById(1);

	}

}
