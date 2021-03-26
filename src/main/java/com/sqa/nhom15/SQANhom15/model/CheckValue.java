package com.sqa.nhom15.SQANhom15.model;

public enum CheckValue {
    OK("OK"),
    NOT_OK("NOT_OK");

    private final String value;

    private CheckValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
