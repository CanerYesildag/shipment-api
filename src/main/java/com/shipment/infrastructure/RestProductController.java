package com.shipment.infrastructure;

import com.shipment.application.controller.ProductController;
import com.shipment.application.manager.ProductManager;
import com.shipment.application.model.request.ProductRequest;
import com.shipment.application.model.response.ProductResponse;
import com.shipment.domain.entitiy.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipment/api")
public class RestProductController implements ProductController {

    private final ProductManager productManager;

    public RestProductController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @Override
    @GetMapping(value = "/{id}")
    public Optional<Product> retrieveProduct(@PathVariable String id) {
        return productManager.retrieveProduct(Long.valueOf(id));
    }

    @Override
    @PostMapping(value = "/product/insert")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productManager.createProduct(productRequest);
    }
}
