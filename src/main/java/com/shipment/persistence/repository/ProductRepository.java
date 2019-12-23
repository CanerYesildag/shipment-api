package com.shipment.persistence.repository;

import com.shipment.persistence.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Product findByProductName(String name);

}
