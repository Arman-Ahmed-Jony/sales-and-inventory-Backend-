package com.getanoutfit.salesAndInventory.Mapper;

import com.getanoutfit.salesAndInventory.Product.ProductDto;
import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperBuilder {
    MapperBuilder INSTANCE = Mappers.getMapper(MapperBuilder.class);

    @Mapping(source = "prodDescription", target = "prodDesc")
    @Mapping(source = "prodCategory.categoryName", target = "prodCategory")
    ProductDto productToProductDto(Product product);
//    @Mapping(source = "prodDescription", target = "prodDesc")
//    @Mapping(source = "prodCategory.categoryName", target = "prodCategory")
//    Product ProductDTOToProduct(ProductDto productDto);

    ProductCategoryDTO ProductCategoryToProductCategoryDto(ProductCategory productCategory);

    ProductCategory productCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO);
}
