package com.shipment.domain.vo;

import com.shipment.domain.model.request.ProductRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductRequestToVoConverter implements Function<ProductRequest, ProductCreateVo> {

    @Override
    public ProductCreateVo apply(ProductRequest productRequest) {
        ProductCreateVo productCreateVo = new ProductCreateVo();
        productCreateVo.setName(productRequest.getName());
        productCreateVo.setReferenceCode(productRequest.getReferenceCode());
        productCreateVo.setBuyerId(productRequest.getBuyerId());
        productCreateVo.setPrice(productRequest.getPrice());
        return productCreateVo;
    }
}
