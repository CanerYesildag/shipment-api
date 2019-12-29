package com.shipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2 // Bunu oluştururken http://localhost:8081/swagger-ui.html
public class ShipmentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipmentApiApplication.class, args);
    }

}
