package com.getanoutfit.salesAndInventory;

import com.getanoutfit.salesAndInventory.Product.ProductDto;
import com.getanoutfit.salesAndInventory.Mapper.ProductMapper;
import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalesAndInventoryApplicationTests {

	@Test
	void contextLoads() {
		Product product= new Product();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(1);
		productCategory.setCategoryName("test Name");
		product.setProdName("test");
		product.setProdDescription("test");
		product.setProdPrice(12);
		product.setProdCategory(productCategory);
//		new ProductDto("test", "test", "12");
		ProductDto productDto= ProductMapper.INSTANCE.productToProductDto(product);
		System.out.println("test is "+productDto.toString());
		System.out.println("test is "+product.toString());
		System.out.println(product.equals(productDto));
	}

}
