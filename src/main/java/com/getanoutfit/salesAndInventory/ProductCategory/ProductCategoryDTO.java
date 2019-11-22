package com.getanoutfit.salesAndInventory.ProductCategory;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductCategoryDTO {

    private Integer id;
    @NotNull(message = "product category id can not be empty")
    private String categoryName;
    private Date updated;
}
