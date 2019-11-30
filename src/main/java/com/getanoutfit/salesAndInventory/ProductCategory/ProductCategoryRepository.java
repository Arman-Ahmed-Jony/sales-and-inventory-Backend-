package com.getanoutfit.salesAndInventory.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

//    @Query("SELECT u FROM User u WHERE u.status = ?1")
//    User findUserByStatus(Integer status);
//    @Query("delete from product p where p.productCategory = ?1")
//    void deleteAllById(Integer id);
}
