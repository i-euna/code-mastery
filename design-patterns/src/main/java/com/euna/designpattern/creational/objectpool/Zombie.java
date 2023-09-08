package com.euna.designpattern.creational.objectpool;

import java.util.concurrent.atomic.AtomicInteger;

public class Zombie {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;
    public Zombie() {
        id = counter.incrementAndGet();
    }
    public int getId() {
        return id;
    }
}
