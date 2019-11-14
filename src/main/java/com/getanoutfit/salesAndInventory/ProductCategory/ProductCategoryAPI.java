package com.getanoutfit.salesAndInventory.ProductCategory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/productcat")
@RequiredArgsConstructor
@Slf4j
public class ProductCategoryAPI {

    private final ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> findAll() {
        log.error("findAll mehthod is called");
        log.error(productCategoryService.findAll().toString());
        return ResponseEntity.ok(productCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> findById(@PathVariable Integer id) {
        Optional<ProductCategory> productCategory = productCategoryService.findById(id);
        if (!productCategory.isPresent()) {
            log.error("product category is not found");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productCategory.get());
    }

    @PostMapping
    public ResponseEntity<ProductCategory> save(@Valid @RequestBody ProductCategory productCategory) {
        return ResponseEntity.ok(productCategoryService.save(productCategory));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductCategory> update(@PathVariable Integer id, @Valid @RequestBody ProductCategory productCategory) {
        log.info("update product category method called");
        if (!productCategoryService.findById(id).isPresent()) {
            log.error("product category not available");
            return ResponseEntity.badRequest().build();
        }
        log.info("got a product category of :  "+productCategory.toString());
        Optional<ProductCategory> previousDataInDataBase= productCategoryService.findById(id);
        if(productCategory.getCategoryId()==null){
//            productCategory.setId(id);
            productCategory.setCategoryId(previousDataInDataBase.get().getCategoryId());
        }
        return ResponseEntity.ok(productCategoryService.update(productCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        Map response = new HashMap<String, String>();
        if (!productCategoryService.findById(id).isPresent()) {
            log.error("product category not found");
            response.put("status", "404");
            response.put("message", "resource not found");
            return ResponseEntity.ok(response);
        }
        productCategoryService.deleteById(id);
        response.put("status", "204");
        response.put("message", "resource deleted successfully");
        return ResponseEntity.ok(response);
    }
}
