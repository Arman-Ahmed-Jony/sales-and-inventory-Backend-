package com.getanoutfit.salesAndInventory.API;

import com.getanoutfit.salesAndInventory.Model.Product;
import com.getanoutfit.salesAndInventory.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductAPI {
private final ProductService productService;

//    public ProductAPI(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            log.error("ID: "+id+" is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product.get());
    }
}
