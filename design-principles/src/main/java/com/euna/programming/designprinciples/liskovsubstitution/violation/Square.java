package com.euna.programming.designprinciples.liskovsubstitution.violation;

class Square extends Shape {

    @Override
    public int calcualteArea() {
        return 0;
    }

    @Override
    public int getDiameter() {
        //don't need this for square
        return 0;
    }
}
