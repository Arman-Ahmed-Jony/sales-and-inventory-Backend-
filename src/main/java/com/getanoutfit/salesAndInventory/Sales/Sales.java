package com.getanoutfit.salesAndInventory.Sales;

import com.getanoutfit.salesAndInventory.Product.Product;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

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
    private Set<SalesProducts> products = new HashSet<>();
    private String commnet;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
}
