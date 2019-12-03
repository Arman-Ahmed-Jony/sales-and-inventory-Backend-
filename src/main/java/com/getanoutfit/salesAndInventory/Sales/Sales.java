package com.getanoutfit.salesAndInventory.Sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getanoutfit.salesAndInventory.Employee.Employee;
import com.getanoutfit.salesAndInventory.Sales.SalesProduct.SalesProducts;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "sales")
    @JsonIgnore
    private Set<SalesProducts> products = new HashSet<>();
    private String comment;
    @OneToOne
    private Employee employee;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
}
