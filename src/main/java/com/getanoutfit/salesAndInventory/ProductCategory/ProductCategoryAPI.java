package com.getanoutfit.salesAndInventory.ProductCategory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/productcat")
@RequiredArgsConstructor
@Slf4j
public class ProductCategoryAPI {

    private final ProductCategoryService productCategoryService;

    @GetMapping
    private ResponseEntity<List<ProductCategory>> findAll(){
        log.error("findAll mehthod is called");
        log.error(productCategoryService.findAll().toString());
        return ResponseEntity.ok(productCategoryService.findAll());
    }
}
