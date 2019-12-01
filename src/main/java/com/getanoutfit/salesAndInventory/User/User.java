package com.getanoutfit.salesAndInventory.User;

import com.getanoutfit.salesAndInventory.Employee.Employee;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Employee employee;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    private String pass;
    @Enumerated(EnumType.ORDINAL)
    private UserType type;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;

}
