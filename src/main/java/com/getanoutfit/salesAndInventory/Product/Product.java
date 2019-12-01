package com.getanoutfit.salesAndInventory.Product;

import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import com.getanoutfit.salesAndInventory.Sales.SalesProduct.SalesProducts;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
//@JsonIdentityInfo(scope = Product.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //    @NotNull
    @Id
    private Integer prodId;

    //    @NotNull
    private String prodName;

    private String prodDescription;

    //    @NotNull
    private int prodPrice;

    private int prodQuantity;

//    @ManyToOne(cascade = CascadeType.ALL, mapp)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    private Set<SalesProducts> sales= new HashSet<>();
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

}