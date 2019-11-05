package com.getanoutfit.salesAndInventory.Service;

import com.getanoutfit.salesAndInventory.Repository.ProductRepository;
import com.getanoutfit.salesAndInventory.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
