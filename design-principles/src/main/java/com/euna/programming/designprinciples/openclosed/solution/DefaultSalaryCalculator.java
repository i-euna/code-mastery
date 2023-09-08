package com.euna.programming.designprinciples.openclosed.solution;

public class DefaultSalaryCalculator implements SalaryCalculator {
    @Override
    public long calculateSalary() {
        return 60;
    }
}