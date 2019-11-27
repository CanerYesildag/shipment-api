package com.shipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShipmentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipmentApiApplication.class, args);
    }

}
