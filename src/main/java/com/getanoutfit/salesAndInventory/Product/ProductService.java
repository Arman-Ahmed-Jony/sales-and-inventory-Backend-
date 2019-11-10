package com.getanoutfit.salesAndInventory.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product findByProdIdAndProdName(Integer prodId, String prodName) {
        return productRepository.findByProdIdAndProdName(prodId, prodName);
    }
    public List<Product> findByCreatedBetween(Date startDate, Date endDate){
        return productRepository.findByCreatedBetween(startDate, endDate);
    }
}
