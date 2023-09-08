package com.euna.designpattern.creational.objectpool;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {
    private final Set<T> freeToUs = new HashSet<>();
    private final Set<T> inUse = new HashSet<>();

    protected abstract T create();

    public synchronized T checkOut() {
        if (freeToUs.isEmpty()) {
            freeToUs.add(create());
        }
        var instance = freeToUs.iterator().next();
        freeToUs.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void checkIn(T instance) {
        inUse.remove(instance);
        freeToUs.add(instance);
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", freeToUs.size(), inUse.size());
    }
}
