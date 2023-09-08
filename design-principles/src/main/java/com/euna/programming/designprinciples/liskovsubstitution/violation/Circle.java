package com.euna.programming.designprinciples.liskovsubstitution.violation;

public class Circle extends Shape {
    @Override
    public int calcualteArea() {
        return 0;
    }

    @Override
    public int getDiameter() {
        return 0;
    }
}