package com.getanoutfit.salesAndInventory.Sales;

import lombok.Data;

import java.util.Date;

@Data
public class SalesDTO {
    private Integer id;
    private String comment;
    private Integer empId;
    private String empName;
    private Date created;
}
