package com.api.dto;

import java.io.Serializable;

public class Ticket implements Serializable {

    private static final long serialVersionUID = 6432784236L;

    private String department;
    private String identifier;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
