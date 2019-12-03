package com.getanoutfit.salesAndInventory.Sales;

import com.getanoutfit.salesAndInventory.Product.ProductDto;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class SalesDTO {
    private Integer id;
    private Set<ProductDto> products;
    private String comment;
    private Integer empId;
    private Date updated;
}