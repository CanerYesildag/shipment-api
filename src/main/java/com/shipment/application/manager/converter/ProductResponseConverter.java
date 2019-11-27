package com.shipment.application.manager.converter;

import com.shipment.application.enumType.ResponseType;
import com.shipment.application.model.dto.ProductDto;
import com.shipment.application.model.response.ProductResponse;
import com.shipment.domain.vo.ProductVo;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseConverter {

    private final ProductVoToDtoConverter productVoToDtoConverter;

    public ProductResponseConverter(ProductVoToDtoConverter productVoToDtoConverter) {
        this.productVoToDtoConverter = productVoToDtoConverter;
    }

    public ProductResponse convert(ProductVo productVo, String advertisement) {
        ProductResponse productResponse = new ProductResponse();
        ProductDto productDto = productVoToDtoConverter.apply(productVo, advertisement);
        productResponse.setStatus(ResponseType.SUCCESS.getValue());
        productResponse.setProductDto(productDto);
        return productResponse;
    }
}
