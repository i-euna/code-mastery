package com.euna.programming.designprinciples.dependencyinversion.solution;

public class LightBulb implements SwitchableDevice {
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Light bulb is on");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Light bulb is off");
    }

    @Override
    public boolean isOn() {
        return on;
    }
}
