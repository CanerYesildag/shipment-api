package com.shipment.application.manager;

import com.shipment.application.manager.converter.ProductResponseConverter;
import com.shipment.application.model.request.ProductRequest;
import com.shipment.application.model.response.ProductResponse;
import com.shipment.application.vo.ProductCreateVo;
import com.shipment.application.vo.ProductRequestToVoConverter;
import com.shipment.domain.entitiy.Product;
import com.shipment.domain.service.AdvertisementApiCallerService;
import com.shipment.domain.service.ProductService;
import com.shipment.domain.vo.ProductVo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductManager {

    private final ProductRequestToVoConverter productRequestToVoConverter;
    private final ProductService productService;
    private final ProductResponseConverter productResponseConverter;
    private final AdvertisementApiCallerService advertisementApiCallerService;

    public ProductManager(ProductRequestToVoConverter productRequestToVoConverter,
                          ProductService productService,
                          ProductResponseConverter productResponseConverter,
                          AdvertisementApiCallerService advertisementApiCallerService) {
        this.productRequestToVoConverter = productRequestToVoConverter;
        this.productService = productService;
        this.productResponseConverter = productResponseConverter;
        this.advertisementApiCallerService = advertisementApiCallerService;
    }

    public Optional<Product> retrieveProduct(Long id) {
        Optional<Product> productOpt = productService.retrieveProduct(id);
         productOpt.ifPresent(product -> {
            String advertisement = advertisementApiCallerService.giveAdvertisement();
            product.setName( advertisement + product.getName());
        });
         return productOpt;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        ProductCreateVo productCreateVo = productRequestToVoConverter.apply(productRequest);
        ProductVo productVo = productService.createProduct(productCreateVo);
        String giveAdvertisement = advertisementApiCallerService.giveAdvertisementUsingName(productVo.getName());
        ProductResponse productResponse = productResponseConverter.convert(productVo, giveAdvertisement);
        return productResponse;
    }
}
