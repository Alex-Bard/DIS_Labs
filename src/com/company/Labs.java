package com.company;

public enum Labs {
    LAB1("Lab1"),LAB2("Lab2");
    private String name;

    Labs(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
