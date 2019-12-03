package com.getanoutfit.salesAndInventory.Sales;

import com.getanoutfit.salesAndInventory.Employee.Employee;
import com.getanoutfit.salesAndInventory.Mapper.MapperBuilder;
import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.Product.ProductDto;
import com.getanoutfit.salesAndInventory.Sales.SalesProduct.SalesProducts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sales")
@Slf4j
public class SalesAPI {
    @Autowired
    private SalesService salesService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        Map response = new HashMap<>();
        List<Sales> sales = salesService.findAll();
//        SalesDTO salesDTO = MapperBuilder.INSTANCE.
        response.put("data", sales);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@Valid @RequestBody SalesDTO salesDTO) {
//        Sales sales = new Sales();
//        sales.setComment("test comment");
////        salesService.save()
//        Employee employee = new Employee();
//        employee.setId(1);
//        sales.setEmployee(employee);
//
//        Set<SalesProducts> listOfProducts = new HashSet<>();
//        SalesProducts salesProducts = new SalesProducts();
//        Product product = new Product();
//        product.setId(1);
//        salesProducts.setProduct(product);
//        SalesProducts.SalesProductsId salesProductsId = new SalesProducts.SalesProductsId();
//        salesProductsId.setProductId(product.getId());
//        salesProductsId.setSaleId(1);
//        salesProducts.setSalesProductsId(salesProductsId);
////        salesProducts.setSalesProductsId();
//        listOfProducts.add(salesProducts);
//        sales.setProducts(listOfProducts);
//        salesService.save(sales);
//salesDTO.setComment("teset");
//salesDTO.setEmpId(1);
//salesDTO.setId(2);
//salesDTO.setProducts(new ProductDto[]);
//        Set<ProductDto> =
//        salesDTO.setProducts();
        Set<Product> products = salesDTO.getProducts().stream().map(productDto -> MapperBuilder.INSTANCE.productDTOToProduct(productDto)).collect(Collectors.toSet());
        Sales sales = MapperBuilder.INSTANCE.salesDTOToSalse(salesDTO);
//        sales.setProducts(products);
        SalesProducts salesProducts = new SalesProducts();
        salesProducts.setSalesProductsId(new SalesProducts.SalesProductsId(1,1));
        return ResponseEntity.ok(salesProducts);

    }
}
