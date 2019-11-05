package com.getanoutfit.salesAndInventory.Model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int prodId;
    private String prodName;
    private String prodDescription;
    private int prodPrice;
    private int prodQuantity;
    private String prodCategory;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;


}
