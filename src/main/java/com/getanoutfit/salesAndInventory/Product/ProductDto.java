package com.getanoutfit.salesAndInventory.Product;


import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class ProductDto {

    private Integer prodId;
    private String prodName;
    private String prodDesc;
    private String prodPrice;
    private int prodQuantity;
    private String prodCategory;
    private Date updated;

}

