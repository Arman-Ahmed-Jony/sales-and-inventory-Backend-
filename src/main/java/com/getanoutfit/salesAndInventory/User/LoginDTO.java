package com.getanoutfit.salesAndInventory.User;

import lombok.Data;

@Data
public class LoginDTO {
    private String userName;
    private String pass;
    private String type;
}
