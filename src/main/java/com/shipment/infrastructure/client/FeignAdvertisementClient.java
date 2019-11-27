package com.shipment.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Primary
@FeignClient( url = "localhost:8090", name = "advertisement-api")
public interface FeignAdvertisementClient {

    @GetMapping(value = "/advertisement/api/{productName}")
    String giveAdvertisementUsingName(@PathVariable  String productName);

    @GetMapping(value = "/advertisement/api/productName")
    String giveAdvertisement();

}
