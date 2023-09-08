package com.euna.programming.designprinciples.dependencyinversion.solution;

public class Switch {
    private SwitchableDevice device;

    public Switch(SwitchableDevice device) {
        this.device = device;
    }

    public void operate() {
        if (device != null) {
            if (device.isOn()) {
                device.turnOff();
            } else {
                device.turnOn();
            }
        }
    }
}
