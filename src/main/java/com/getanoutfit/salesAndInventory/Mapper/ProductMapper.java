package com.getanoutfit.salesAndInventory.Mapper;

import com.getanoutfit.salesAndInventory.Product.ProductDto;
import com.getanoutfit.salesAndInventory.Product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

@Mapping(source = "prodDescription",target = "prodDesc")
@Mapping(source = "prodCategory.categoryName", target = "prodCategory")
ProductDto productToProductDto(Product product);
}
