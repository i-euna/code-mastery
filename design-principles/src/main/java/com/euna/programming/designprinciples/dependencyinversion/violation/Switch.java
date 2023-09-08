package com.euna.programming.designprinciples.dependencyinversion.violation;

public class Switch {
    private LightBulb bulb;

    public Switch() {
        this.bulb = new LightBulb();
    }

    public void operate() {
        if (bulb != null) {
            if (bulb.isOn()) {
                bulb.turnOff();
            } else {
                bulb.turnOn();
            }
        }
    }
}