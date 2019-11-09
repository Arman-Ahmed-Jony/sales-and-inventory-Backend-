package com.getanoutfit.salesAndInventory.Model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private Integer prodId;

    @NotNull
    private String prodName;

    private String prodDescription;

    @NotNull
    private int prodPrice;

    private int prodQuantity;

    private String prodCategory;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;


}
