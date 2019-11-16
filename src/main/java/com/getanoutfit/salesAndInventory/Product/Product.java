package com.getanoutfit.salesAndInventory.Product;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@JsonIdentityInfo(scope = Product.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @NotNull
    @Column(unique = true)
    private Integer prodId;

    //    @NotNull
    private String prodName;

    private String prodDescription;

    //    @NotNull
    private int prodPrice;

    private int prodQuantity;

    @ManyToOne()
    @JoinColumn(name="category_id", nullable=false)
    private ProductCategory prodCategory;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;


}