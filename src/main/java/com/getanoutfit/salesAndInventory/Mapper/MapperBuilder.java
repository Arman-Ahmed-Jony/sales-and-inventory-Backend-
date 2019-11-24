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
    @Mapping(source = "prodCategory.id", target = "prodCategory")
    @Mapping(source = "id",target = "prodId")
    ProductDto productToProductDto(Product product);

    @Mapping(source = "prodDesc", target = "prodDescription")
    @Mapping(source = "prodCategory", target = "prodCategory.id")
    @Mapping(source = "prodId",target = "id")
    Product productDTOToProduct(ProductDto productDto);

    ProductCategoryDTO productCategoryToProductCategoryDto(ProductCategory productCategory);

    ProductCategory productCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO);
}
