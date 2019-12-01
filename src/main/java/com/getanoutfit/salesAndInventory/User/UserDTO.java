package com.getanoutfit.salesAndInventory.User;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Integer id;
    private Integer empId;
    private String userName;
    private String pass;
    private UserType type;
    private Date updated;
}
