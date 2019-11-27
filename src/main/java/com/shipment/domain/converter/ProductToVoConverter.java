package com.shipment.domain.converter;

import com.shipment.domain.entitiy.Product;
import com.shipment.domain.vo.ProductVo;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductToVoConverter implements Function<Product, ProductVo> {

    @Override
    public ProductVo apply(Product product) {
        ProductVo productVo = new ProductVo();
        productVo.setName(product.getName());
        productVo.setBuyerId(product.getBuyerId());
        productVo.setReferenceCode(product.getReferenceCode());
        productVo.setPrice(product.getPrice());
        return productVo;
    }
}
