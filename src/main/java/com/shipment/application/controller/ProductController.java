package com.shipment.application.controller;

import com.shipment.domain.entitiy.Product;
import com.shipment.application.model.request.ProductRequest;
import com.shipment.application.model.response.ProductResponse;

import java.util.Optional;

public interface ProductController {

    Optional<Product> retrieveProduct(String productName);

    ProductResponse createProduct(ProductRequest productRequest);
}
