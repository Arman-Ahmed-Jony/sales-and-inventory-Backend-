package com.getanoutfit.salesAndInventory.ProductCategory;

import com.getanoutfit.salesAndInventory.Product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private Integer categoryId;

    @NotNull
    private String categoryName;

//    @OneToMany(mappedBy = "prodCategory")
//    private List<Product> productList;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;
}
