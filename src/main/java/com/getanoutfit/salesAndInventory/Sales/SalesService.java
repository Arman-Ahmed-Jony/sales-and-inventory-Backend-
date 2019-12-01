package com.getanoutfit.salesAndInventory.Sales;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> findAll() {
        return salesRepository.findAll();
    }

    public Optional<Sales> findById(Integer id) {
        return salesRepository.findById(id);
    }

    public Sales save(Sales sales){
        return salesRepository.save(sales);
    }

    public void deleteById(Integer id){
        salesRepository.deleteById(id);
    }

}
