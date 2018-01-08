package com.commons.entities;

public class Identity {

    private long cellNumber;
    private String name;

    public Identity() {
    }

    public Identity(long cellNumber, String name) {
        this.cellNumber = cellNumber;
        this.name = name;
    }

    public long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
