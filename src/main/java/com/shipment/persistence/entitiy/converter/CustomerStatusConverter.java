package com.shipment.persistence.entitiy.converter;

import com.shipment.persistence.enumtype.CustomerStatus;

import javax.persistence.AttributeConverter;

public class CustomerStatusConverter implements AttributeConverter<CustomerStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CustomerStatus status) {
        return status.getValue();
    }

    @Override
    public CustomerStatus convertToEntityAttribute(Integer value) {
        String enumName = CustomerStatus.getStringName(value);
        return CustomerStatus.valueOf(enumName);
    }
}
