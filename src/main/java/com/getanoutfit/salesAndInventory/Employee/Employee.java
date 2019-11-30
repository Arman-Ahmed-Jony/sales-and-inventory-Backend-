package com.getanoutfit.salesAndInventory.Employee;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private FullName fullName;
    private Address address;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;

    @Embeddable
    @Data
    public static class FullName implements Serializable {
        protected String fname;
        protected String lname;
    }

    @Embeddable
    @Data
    public static class Address implements Serializable {
        private String permanentAddress;
        private String residentialAddress;
    }

}
