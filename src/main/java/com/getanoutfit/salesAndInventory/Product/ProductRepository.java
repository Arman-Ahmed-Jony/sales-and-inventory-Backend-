package com.getanoutfit.salesAndInventory.Product;

import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProdIdAndProdName(Integer prodId, String prodName);
    List<Product> findByCreatedBetween(Date startDate, Date endDate);
////    @Query("delete from product p where p.productCategory = ?1")
////    void deleteAllById(Integer id);
//    void deleteByProductCategory(Integer category);
@Modifying
@Transactional
@Query("delete from Product p where productCategory.id = ?1")
void deleteByCategoryId(Integer id);
}