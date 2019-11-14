package com.getanoutfit.salesAndInventory.ProductCategory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getanoutfit.salesAndInventory.Product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class ProductCategory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(unique = true, updatable = false)
//    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

//    @NotNull
    private String categoryName;

    //    @OneToMany(mappedBy = "prodCategory")
//    private List<Product> productList;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "prodId")
    private Set<Product> items = new HashSet<Product>();

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;
}
