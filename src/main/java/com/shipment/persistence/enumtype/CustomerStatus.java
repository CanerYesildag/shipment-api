package com.shipment.persistence.enumtype;

import com.shipment.web.EnumValue;

public enum CustomerStatus implements EnumValue<Integer> {

    ACTIVE(1),
    PASSIVE(0),
    CANCELED(-1);

    private final Integer value;

    CustomerStatus(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public static String getStringName(Integer integer) {
        String name;
        if (integer == 0)
            name = "PASSIVE";
        else if (integer == 1)
            name = "ACTIVE";
        else name = "CANCELED";
        return name;
    }
}
