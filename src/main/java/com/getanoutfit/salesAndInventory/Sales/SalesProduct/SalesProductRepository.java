package com.getanoutfit.salesAndInventory.Sales.SalesProduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesProductRepository extends JpaRepository<SalesProducts, SalesProducts.SalesProductsId> {
}
