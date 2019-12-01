package com.getanoutfit.salesAndInventory.Sales.SalesProduct;

import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.Sales.Sales;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class SalesProducts {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
    @EmbeddedId
    private SalesProductsId salesProductsId;

    @ManyToOne
    @JoinColumn(name = "fk_sale", insertable = false, updatable = false)
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "fk_product", insertable = false, updatable = false)
    private Product product;

    private Integer quantity;
    private Integer price;

    @Embeddable
    @Data
    public static class SalesProductsId implements Serializable {
        @Column(name = "fk_sale")
        protected Integer saleId;
        @Column(name = "fk_product")
        protected Integer productId;


    }
}
