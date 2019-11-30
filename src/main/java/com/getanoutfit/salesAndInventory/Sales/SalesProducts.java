package com.getanoutfit.salesAndInventory.Sales;

import com.getanoutfit.salesAndInventory.Product.Product;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class SalesProducts {

@EmbeddedId
private SalesProductsId id;

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
    public static class SalesProductsId implements Serializable{
        @Column(name = "fk_sale")
        protected Integer saleId;
        @Column(name = "fk_product")
        protected Integer productId;


    }
}
