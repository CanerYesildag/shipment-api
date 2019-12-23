package com.shipment.web;

import com.shipment.domain.controller.ProductController;
import com.shipment.domain.operator.ProductOperator;
import com.shipment.domain.model.request.ProductRequest;
import com.shipment.domain.model.response.ProductResponse;
import com.shipment.persistence.entitiy.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipment/api")
public class RestProductController implements ProductController {

    private final ProductOperator productOperator;

    public RestProductController(ProductOperator productOperator) {
        this.productOperator = productOperator;
    }

    @Override
    @GetMapping(value = "/{id}")
    public Optional<Product> retrieveProduct(@PathVariable String id) {
        return productOperator.retrieveProduct(Long.valueOf(id));
    }

    @Override
    @PostMapping(value = "/product/insert")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productOperator.createProduct(productRequest);
    }
}
