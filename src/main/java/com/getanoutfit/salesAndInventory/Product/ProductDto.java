package com.getanoutfit.salesAndInventory.Product;


import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {

    private Integer prodId;
    private String prodName;
    private String prodDesc;
    private int prodPrice;
    private int prodQuantity;
    private Integer prodCategory;
    private Date updated;

}

