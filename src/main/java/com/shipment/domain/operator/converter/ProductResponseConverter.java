package com.shipment.domain.operator.converter;

import com.shipment.domain.enumType.ResponseType;
import com.shipment.domain.model.dto.ProductDto;
import com.shipment.domain.model.response.ProductResponse;
import com.shipment.persistence.vo.ProductVo;
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
