package com.getanoutfit.salesAndInventory.Employee;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {
    private int id;
    private String fname;
    private String lname;
    private String permanentAddress;
    private String residentialAddress;
    private Date updated;
}
