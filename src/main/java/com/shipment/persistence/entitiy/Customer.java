package com.shipment.persistence.entitiy;

import com.shipment.persistence.entitiy.converter.CustomerStatusConverter;
import com.shipment.persistence.enumtype.CustomerStatus;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "customer_status")
    @Convert(converter = CustomerStatusConverter.class)
    private CustomerStatus customerStatus;
}
