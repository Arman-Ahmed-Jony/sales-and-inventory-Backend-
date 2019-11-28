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
//@Data
//@JsonIdentityInfo(scope = ProductCategory.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductCategory {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(unique = true, updatable = false)
//    @Column(name = "category_id")
    @Id
    @Column(name = "product_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CATEGORY_ID")
    private Integer id;

    //    @NotNull
    private String categoryName;

    //    @OneToMany(mappedBy = "prodCategory")
////    private List<Product> productList;
//    @JsonIgnore
    @OneToMany(mappedBy = "productCategory")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.DELETE,
            org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private Set<Product> items = new HashSet<Product>();

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    public ProductCategory(Integer id, String categoryName, Set<Product> items, Date created, Date updated) {
        this.id = id;
        this.categoryName = categoryName;
       // this.items = items;
        this.created = created;
        this.updated = updated;
    }

    public ProductCategory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

  /* public Set<Product> getItems() {
        return items;
    }

    public void setItems(Set<Product> items) {
        this.items = items;
    }*/

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
        ProductCategory that = (ProductCategory) o;
        return id.equals(that.id) &&
                categoryName.equals(that.categoryName) &&
              //  items.equals(that.items) &&
                created.equals(that.created) &&
                updated.equals(that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, created, updated);
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
               // ", items=" + items +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}