package com.shipment.domain.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shipment.domain.model.dto.ProductDto;

public class ProductResponse {

    @JsonProperty("data")
    private ProductDto productDto;
    private String status;

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
