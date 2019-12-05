package com.getanoutfit.salesAndInventory.Sales.SalesProduct;

import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.Sales.Sales;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class SalesProducts implements Serializable{
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

    public static class SalesProductsId implements Serializable {
        @Column(name = "fk_sale")
        protected Integer saleId;
        @Column(name = "fk_product")
        protected Integer productId;

        public SalesProductsId() {
        }

        public SalesProductsId(Integer saleId, Integer productId) {
            this.saleId = saleId;
            this.productId = productId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null)
                return false;
            if (getClass() != o.getClass())
                return false;

            SalesProductsId other = (SalesProductsId) o;

            if (saleId == null) {
                if (other.saleId != null)
                    return false;
            } else if (!saleId.equals(other.saleId))
                return false;

            if (productId == null) {
                if (other.productId != null)
                    return false;
            } else if (!productId.equals(other.productId))
                return false;

            return true;

        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((saleId == null) ? 0 : saleId.hashCode());
            result = prime * result
                    + ((productId == null) ? 0 : productId.hashCode());
            return result;
        }
    }

    public SalesProducts(Sales sales, Product product, Integer quantity, Integer price) {
        this.salesProductsId=new SalesProductsId(sales.getId(), product.getId());
        this.sales = sales;
        this.product = product;
        this.quantity = quantity;
        this.price = price;

        sales.getProducts().add(this);
        product.getSales().add(this);
    }

    public SalesProducts() {
    }

    public SalesProductsId getSalesProductsId() {
        return salesProductsId;
    }

    public void setSalesProductsId(SalesProductsId salesProductsId) {
        this.salesProductsId = salesProductsId;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesProducts that = (SalesProducts) o;
        return Objects.equals(salesProductsId, that.salesProductsId) &&
                Objects.equals(sales, that.sales) &&
                Objects.equals(product, that.product) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price);
    }



    @Override
    public String toString() {
        return "SalesProducts{" +
                "salesProductsId=" + salesProductsId +
                ", sales=" + sales.getId() +
                ", product=" + product.getProdName() +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
