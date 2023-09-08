package com.euna.programming.designprinciples.openclosed.violation;

public class SalaryCalculator {
    public long calculateSalary(String employeeType) {
        if (employeeType == "X") {
            return 100;
        }
        else if (employeeType == "Y") {
            return 80;
        }
        else {
            return 60;
        }
    }
}
