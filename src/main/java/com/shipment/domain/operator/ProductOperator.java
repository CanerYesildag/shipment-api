package com.shipment.domain.operator;

import com.shipment.domain.operator.converter.ProductResponseConverter;
import com.shipment.domain.model.request.ProductRequest;
import com.shipment.domain.model.response.ProductResponse;
import com.shipment.domain.vo.ProductCreateVo;
import com.shipment.domain.vo.ProductRequestToVoConverter;
import com.shipment.persistence.entitiy.Product;
import com.shipment.persistence.service.AdvertisementApiCallerService;
import com.shipment.persistence.service.ProductService;
import com.shipment.persistence.vo.ProductVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductOperator {

    private final Logger logger = LoggerFactory.getLogger(ProductOperator.class);

    private final ProductRequestToVoConverter productRequestToVoConverter;
    private final ProductService productService;
    private final ProductResponseConverter productResponseConverter;
    private final AdvertisementApiCallerService advertisementApiCallerService;

    public ProductOperator(ProductRequestToVoConverter productRequestToVoConverter,
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
            logger.info("AdvertisementCallerService called advertisement: {}", advertisement);
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
