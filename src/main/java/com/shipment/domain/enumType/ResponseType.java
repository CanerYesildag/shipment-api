package com.shipment.domain.enumType;

public enum ResponseType {
    SUCCESS("success"),
    FAILURE("failure");

    private final String value;

    ResponseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
