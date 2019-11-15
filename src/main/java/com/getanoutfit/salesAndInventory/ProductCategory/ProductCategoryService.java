package com.getanoutfit.salesAndInventory.ProductCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll(){

        return productCategoryRepository.findAll();
    }

}
