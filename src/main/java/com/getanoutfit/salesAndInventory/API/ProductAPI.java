package com.getanoutfit.salesAndInventory.API;

import com.getanoutfit.salesAndInventory.Model.Product;
import com.getanoutfit.salesAndInventory.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(@Nullable @RequestParam("startDate") String startDate,
                                                 @Nullable @RequestParam("endDate") String endDate) throws ParseException {

        if (startDate != null & endDate != null) {
            log.info("query startDate: "+startDate+" "+"query endDate: "+endDate);
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            return ResponseEntity.ok(productService.findByCreatedBetween(date1, date2));
        }
        log.error(startDate);
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            log.error("ID: " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @Valid @RequestBody Product product) {
        if (!productService.findById(id).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!productService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
