package com.euna.programming.designprinciples.singlereponsibility.violation;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    public long calculateSalary() {
        //logic for calculating salary
        return 0;
    }
    public void save() {
        //logic for saving data to DB
    }
    public String reportAttendance() {
        //logic for reporting attendence in office
        return "";
    }
}
