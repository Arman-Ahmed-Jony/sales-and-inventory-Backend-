package com.getanoutfit.salesAndInventory.ProductCategory;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.getanoutfit.salesAndInventory.Product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
//@JsonIdentityInfo(scope = ProductCategory.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductCategory {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(unique = true, updatable = false)
//    @Column(name = "category_id")
    @Id
//    @Column(name = "product_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CATEGORY_ID")
    private Integer id;

    //    @NotNull
    private String categoryName;

    //    @OneToMany(mappedBy = "prodCategory")
////    private List<Product> productList;
//    @JsonIgnore
//    @OneToMany(orphanRemoval = true)
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
//            org.hibernate.annotations.CascadeType.DELETE,
//            org.hibernate.annotations.CascadeType.MERGE,
//            org.hibernate.annotations.CascadeType.PERSIST,
//            org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
//    private Set<Product> items = new HashSet<Product>();

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;
}