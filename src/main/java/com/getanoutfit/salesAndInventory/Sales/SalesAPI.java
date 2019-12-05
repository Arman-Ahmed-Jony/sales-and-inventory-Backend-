package com.getanoutfit.salesAndInventory.Sales;

import com.getanoutfit.salesAndInventory.Employee.Employee;
import com.getanoutfit.salesAndInventory.Employee.EmployeeService;
import com.getanoutfit.salesAndInventory.Mapper.MapperBuilder;
import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.Product.ProductDto;
import com.getanoutfit.salesAndInventory.Product.ProductService;
import com.getanoutfit.salesAndInventory.Sales.SalesProduct.SalesProductService;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sales")
@Slf4j
public class SalesAPI {
    @Autowired
    private SalesService salesService;
    @Autowired
    private SalesProductService salesProductService;
    @Autowired
    private ProductService productService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        Map response = new HashMap<>();
//        List<SalesProducts> salesProducts = new ArrayList<>();
        List<Sales> salesList = salesService.findAll();
//        List<SalesDTO> salesDTOS = sales.stream().map(sale -> MapperBuilder.INSTANCE.productToProductDto(product)).collect(Collectors.toList());
        List<SalesDTO> salesDTOS = new ArrayList<>();
        for (Sales sales :
                salesList) {
            log.info(sales.toString());
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setId(sales.getId());
            salesDTO.setComment(sales.getComment());
            salesDTO.setEmpId(sales.getEmployee().getId());
            salesDTO.setUpdated(sales.getUpdated());

            Set<ProductDto> productDtos = new HashSet<>();

            for (SalesProducts products :
                    sales.getProducts()) {
                ProductDto productDto = new ProductDto();
                productDto.setProdId(products.getProduct().getProdId());
                productDto.setProdName(products.getProduct().getProdName());
                productDto.setProdCategory(products.getProduct().getProductCategory().getId());
                productDto.setProdPrice(products.getPrice());
                productDto.setProdQuantity(products.getQuantity());

                productDtos.add(productDto);
            }

            salesDTO.setProducts(productDtos);
            salesDTOS.add(salesDTO);
        }

        response.put("data", salesDTOS);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@Valid @RequestBody SalesDTO salesDTO) {

        log.info(salesDTO.toString());
        Sales sales = new Sales();

        sales.setEmployee(employeeService.findById(salesDTO.getEmpId()).get());

//        sales.setComment("test comment");

        salesService.save(sales);


        for (ProductDto products : salesDTO.getProducts()
        ) {
            Product p = productService.findById(products.getProdId()).get();
            SalesProducts salesProducts = new SalesProducts(sales, p, products.getProdQuantity(), products.getProdPrice());
            salesProductService.save(salesProducts);
        }
// up to this done sales saving
        return ResponseEntity.ok(sales);

    }
}
