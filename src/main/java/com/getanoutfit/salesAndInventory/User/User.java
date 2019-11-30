package com.getanoutfit.salesAndInventory.User;

import com.getanoutfit.salesAndInventory.Employee.Employee;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Employee employee;
    private String userName;
    private String pass;
    @Enumerated(EnumType.ORDINAL)
    private UserType type;

}
