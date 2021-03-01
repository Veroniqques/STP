package com.veronica;

public class HourlyHired extends Hired {

    private final double hourlyRate;

    public HourlyHired(int id, double hourlyRate, String name) {
        super(id, name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * hourlyRate;
    }

}
