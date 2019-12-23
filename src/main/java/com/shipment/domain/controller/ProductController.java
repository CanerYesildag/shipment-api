package com.shipment.domain.controller;

import com.shipment.persistence.entitiy.Product;
import com.shipment.domain.model.request.ProductRequest;
import com.shipment.domain.model.response.ProductResponse;

import java.util.Optional;

public interface ProductController {

    Optional<Product> retrieveProduct(String productName);

    ProductResponse createProduct(ProductRequest productRequest);
}
