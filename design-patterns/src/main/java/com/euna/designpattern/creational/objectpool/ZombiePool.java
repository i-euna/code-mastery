package com.euna.designpattern.creational.objectpool;

public class ZombiePool extends ObjectPool<Zombie> {
    @Override
    protected Zombie create() {
        return new Zombie();
    }
}
