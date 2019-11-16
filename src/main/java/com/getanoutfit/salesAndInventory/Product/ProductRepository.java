package com.getanoutfit.salesAndInventory.Product;

import com.getanoutfit.salesAndInventory.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProdIdAndProdName(Integer prodId, String prodName);
    List<Product> findByCreatedBetween(Date startDate, Date endDate);
}