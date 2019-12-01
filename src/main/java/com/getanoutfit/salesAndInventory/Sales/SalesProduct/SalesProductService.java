package com.getanoutfit.salesAndInventory.Sales.SalesProduct;

import com.getanoutfit.salesAndInventory.Sales.Sales;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesProductService {
    @Autowired
    private SalesProductRepository salesProductRepository;

    public List<SalesProducts> findAll(){
        return salesProductRepository.findAll();
    }

//    public SalesProducts findById(){
//        return
//    }
}
