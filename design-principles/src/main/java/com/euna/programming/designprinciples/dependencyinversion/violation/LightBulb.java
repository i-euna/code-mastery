package com.euna.programming.designprinciples.dependencyinversion.violation;

class LightBulb {
    private boolean isOn = false;
    public void turnOn() {
        System.out.println("Light bulb is on");
    }

    public void turnOff() {
        System.out.println("Light bulb is off");
    }

    public boolean isOn() {
        return isOn;
    }
}
