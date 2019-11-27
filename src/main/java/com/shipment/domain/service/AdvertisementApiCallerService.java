package com.shipment.domain.service;

import com.shipment.infrastructure.client.FeignAdvertisementClient;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementApiCallerService {

    private final FeignAdvertisementClient feignAdvertisementClient;

    public AdvertisementApiCallerService(FeignAdvertisementClient feignAdvertisementClient) {
        this.feignAdvertisementClient = feignAdvertisementClient;
    }

    public String giveAdvertisement() {
        return feignAdvertisementClient.giveAdvertisement();
    }

    public String giveAdvertisementUsingName(String productName) {
        return feignAdvertisementClient.giveAdvertisementUsingName(productName);
    }

    public String retrieveDefault() {
        return "My default string is available ";
    }
}
