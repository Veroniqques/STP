package com.veronica;

public class FixedHired extends Hired {

    private final double fixedRate;

    public FixedHired(int id, double fixedRate, String name) {
        super(id, name);
        this.fixedRate = fixedRate;
    }

    @Override
    public double calculateSalary() {
        return fixedRate;
    }
}