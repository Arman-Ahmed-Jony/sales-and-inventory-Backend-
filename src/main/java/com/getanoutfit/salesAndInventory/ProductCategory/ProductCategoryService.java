package com.getanoutfit.salesAndInventory.ProductCategory;

import com.getanoutfit.salesAndInventory.Product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> findById(Integer id) {
        return productCategoryRepository.findById(id);
    }

    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory update(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public void deleteById(Integer id) {
        productRepository.deleteByCategoryId(id);
        productCategoryRepository.deleteById(id);
    }

}