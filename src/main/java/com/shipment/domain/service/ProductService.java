package com.shipment.domain.service;

import com.shipment.application.vo.ProductCreateVo;
import com.shipment.domain.converter.ProductToVoConverter;
import com.shipment.domain.entitiy.Product;
import com.shipment.domain.repository.ProductRepository;
import com.shipment.domain.vo.ProductVo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductToVoConverter productToVoConverter;
    private final ProductRepository productRepository;

    public ProductService(ProductToVoConverter productToVoConverter,
                          ProductRepository productRepository) {
        this.productToVoConverter = productToVoConverter;
        this.productRepository = productRepository;
    }

    public Optional<Product> retrieveProduct(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        return productOpt;
    }

    public ProductVo createProduct(ProductCreateVo productCreateVo) {
        Product product = new Product();
        product.setName(productCreateVo.getName());
        product.setBuyerId(productCreateVo.getBuyerId());
        product.setPrice(productCreateVo.getPrice());
        product.setReferenceCode(productCreateVo.getReferenceCode());
        product.setIdate(new Date(System.currentTimeMillis()));
        Product product1 = productRepository.save(product);
        return productToVoConverter.apply(product1);
    }
}
