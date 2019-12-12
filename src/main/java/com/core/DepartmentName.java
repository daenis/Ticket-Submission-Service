package com.core;

public enum DepartmentName {

    INFORMATION_TECHNOLOGY("Information Technology"),
    SOFTWARE_DEVELOPMENT("Software Development");

    private final String value;

    DepartmentName(String value) {this.value = value;}

    public String getValue() {
        return value;
    }

}
