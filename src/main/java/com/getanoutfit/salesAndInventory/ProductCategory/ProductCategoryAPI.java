package com.getanoutfit.salesAndInventory.ProductCategory;

import com.getanoutfit.salesAndInventory.Mapper.MapperBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/productcat")
@RequiredArgsConstructor
@Slf4j
public class ProductCategoryAPI {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        List<ProductCategoryDTO> dtoList = productCategoryService.findAll().stream().map(product -> MapperBuilder.INSTANCE.ProductCategoryToProductCategoryDto(product)).collect(Collectors.toList());
        Map response = new HashMap();
        response.put("data", dtoList);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<ProductCategory> productCategory = productCategoryService.findById(id);
        Map response = new HashMap();
        if (!productCategory.isPresent()) {
//            log.error("product category is not found");
            response.put("status", HttpServletResponse.SC_NOT_FOUND);
            response.put("message", "no data against this id");
            return ResponseEntity.ok(response);
        }
        ProductCategoryDTO productCategoryDTO = MapperBuilder.INSTANCE.ProductCategoryToProductCategoryDto(productCategory.get());
        response.put("data", productCategoryDTO);
        response.put("status", HttpServletResponse.SC_FOUND);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = MapperBuilder.INSTANCE.productCategoryDTOToProductCategory(productCategoryDTO);

        Map response = new HashMap();
        response.put("data", MapperBuilder.INSTANCE.ProductCategoryToProductCategoryDto(productCategoryService.save(productCategory)));
        response.put("status", "200");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ProductCategoryDTO productCategoryDTO) {
        Map response = new HashMap();
        Optional<ProductCategory> productCategory = productCategoryService.findById(id);
        if (!productCategory.isPresent()) {
            response.put("status", HttpServletResponse.SC_NOT_MODIFIED);
            response.put("message", "no data found against this id");
            return ResponseEntity.ok(response);
        }
        log.info(productCategoryDTO.toString());
        ProductCategory data = MapperBuilder.INSTANCE.productCategoryDTOToProductCategory(productCategoryDTO);
        log.info(data.toString());
        productCategoryService.update(data);
        response.put("data", data);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
//    consumes = MediaType.APPLICATION_JSON_VALUE
    public ResponseEntity deleteById(@PathVariable Integer id) {
        Map response = new HashMap<String, String>();
        if (!productCategoryService.findById(id).isPresent()) {
//            log.error("product category not found");
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