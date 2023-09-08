package com.euna.designpattern.creational.objectpool;

public class Pattern {
    public static void main(String[] args) {
        var pool = new ZombiePool();
        var zombie1 = pool.checkOut();
        var zombie2 = pool.checkOut();
        var zombie3 = pool.checkOut();
        System.out.println(pool);
        pool.checkIn(zombie1);
        pool.checkIn(zombie2);
        var zombie4 = pool.checkOut();
        var zombie5 = pool.checkOut();
    }
}
