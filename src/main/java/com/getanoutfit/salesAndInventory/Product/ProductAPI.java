package com.getanoutfit.salesAndInventory.Product;

import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.Product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findAll(@Nullable @RequestParam("startDate") String startDate,
                                                 @Nullable @RequestParam("endDate") String endDate) throws ParseException {

        if (startDate != null & endDate != null) {
//            log.info("query startDate: "+startDate+" "+"query endDate: "+endDate);
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            return ResponseEntity.ok(productService.findByCreatedBetween(date1, date2));
        }
//        log.error(startDate);
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
//            log.error("ID: " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }


    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> update(@PathVariable Integer id, @Valid @RequestBody Product product) {
        if (!productService.findById(id).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!productService.findById(id).isPresent()) {
//            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}