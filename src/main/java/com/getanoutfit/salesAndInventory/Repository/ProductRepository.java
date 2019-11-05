package com.getanoutfit.salesAndInventory.Repository;

import com.getanoutfit.salesAndInventory.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
