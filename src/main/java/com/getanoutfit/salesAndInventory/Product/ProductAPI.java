package com.getanoutfit.salesAndInventory.Product;

import com.getanoutfit.salesAndInventory.Mapper.MapperBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(@Nullable @RequestParam("startDate") String startDate,
                                     @Nullable @RequestParam("endDate") String endDate) throws ParseException {

        Map response = new HashMap();
        List<Product> data;
        if (startDate != null & endDate != null) {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            data = productService.findByCreatedBetween(date1, date2);
        } else {
            data = productService.findAll();
        }
        List<ProductDto> dtoList = data.stream().map(product -> MapperBuilder.INSTANCE.productToProductDto(product)).collect(Collectors.toList());
        response.put("data", dtoList);
        response.put("status", HttpServletResponse.SC_OK);
        log.error(response.toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        Map response = new HashMap();
        if (!product.isPresent()) {
//            log.error("ID: " + id + " is not existed");
            response.put("status", HttpServletResponse.SC_NOT_FOUND);
            response.put("message", "data not found against this id");
            return ResponseEntity.ok(response);
        }
        ProductDto productDto = MapperBuilder.INSTANCE.productToProductDto(product.get());
        response.put("data", productDto);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@Valid @RequestBody ProductDto productDto) {
        Map response = new HashMap();
        log.error(productDto.toString());
        Product product = MapperBuilder.INSTANCE.productDTOToProduct(productDto);
        log.error(product.toString());
        productService.save(product);
        response.put("data", productDto);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ProductDto productDto) {
        Map response = new HashMap();
        Optional<Product> product = productService.findById(id);
        log.error(product.toString());
        if (!product.isPresent()) {
            response.put("status", HttpServletResponse.SC_NOT_MODIFIED);
            response.put("message", "no data found against this id");
            return ResponseEntity.ok(response);
        }
        log.error(productDto.toString());
        Product request = MapperBuilder.INSTANCE.productDTOToProduct(productDto);
        log.error(request.toString());
        productService.save(request);
//        log.error(product1.toString());
//        ProductDto data = MapperBuilder.INSTANCE.productToProductDto(product.get());
//        log.error(data.toString());
        response.put("data", productDto);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Map response = new HashMap();
        if (!productService.findById(id).isPresent()) {
            response.put("status", HttpServletResponse.SC_NOT_FOUND);
            response.put("message", "data not found against this id");
            return ResponseEntity.ok(response);
        }
        productService.deleteById(id);
        response.put("status", HttpServletResponse.SC_OK);
        response.put("message", "data deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/sendMail")
    public ResponseEntity sendMail(){
        return ResponseEntity.ok("test mail ");
    }

    @PostMapping(value = "uploadImage")
    public ResponseEntity uploadImage(){
        return ResponseEntity.ok("image uploaded");
    }
}