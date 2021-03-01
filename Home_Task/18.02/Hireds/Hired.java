package com.veronica;

public abstract class Hired {

    private final int id;
    private final String name;

    public Hired(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSalary();
}
