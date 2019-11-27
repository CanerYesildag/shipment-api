package com.shipment.application.manager.converter;

import com.shipment.application.model.dto.ProductDto;
import com.shipment.domain.vo.ProductVo;
import org.springframework.stereotype.Component;

@Component
public class ProductVoToDtoConverter {

    public ProductDto apply(ProductVo productVo, String ad) {
        ProductDto productDto = new ProductDto();
        productDto.setName(productVo.getName());
        productDto.setBuyerId(productVo.getBuyerId());
        productDto.setPrice(productVo.getPrice());
        productDto.setReferenceCode(productVo.getReferenceCode());
        productDto.setAdvertisement(ad);
        return productDto;
    }
}
