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
import java.util.Objects;

@Entity
//@JsonIdentityInfo(scope = Product.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

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
    @ManyToOne
    @JoinColumn(name="PRODUCT_CATEGORY_ID")
    private ProductCategory productCategory;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    public Product() {
    }

    public Product(Integer id, Integer prodId, String prodName, String prodDescription, int prodPrice, int prodQuantity, ProductCategory productCategory, Date created, Date updated) {
        this.id = id;
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.prodPrice = prodPrice;
        this.prodQuantity = prodQuantity;
        this.productCategory = productCategory;
        this.created = created;
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prodPrice == product.prodPrice &&
                prodQuantity == product.prodQuantity &&
                Objects.equals(id, product.id) &&
                Objects.equals(prodId, product.prodId) &&
                Objects.equals(prodName, product.prodName) &&
                Objects.equals(prodDescription, product.prodDescription) &&
                Objects.equals(productCategory, product.productCategory) &&
                Objects.equals(created, product.created) &&
                Objects.equals(updated, product.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prodId, prodName, prodDescription, prodPrice, prodQuantity, productCategory, created, updated);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodDescription='" + prodDescription + '\'' +
                ", prodPrice=" + prodPrice +
                ", prodQuantity=" + prodQuantity +
                ", productCategory=" + productCategory +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}