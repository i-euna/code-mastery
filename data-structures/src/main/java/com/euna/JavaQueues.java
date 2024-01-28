package com.euna;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class JavaQueues {
    public static void main(String[] args) {
        demoQueue();

        demoList();
    }

    private static void demoList() {
        LinkedList<Person> list = new LinkedList<>();
        list.add(new Person("Jin"));
        list.add(new Person("Mugen"));
        list.add(new Person("Momo"));

        ListIterator<Person> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void demoQueue() {
        Queue<Person> shopQ = new LinkedList<>();
        shopQ.add(new Person("Jin"));
        shopQ.add(new Person("Mugen"));
        shopQ.add(new Person("Momo"));

        System.out.println("Front : " + shopQ.peek());
        System.out.println("Poll : " + shopQ.poll());
        System.out.println("Size " + shopQ.size());
    }
    private static record Person(String name) {

    }
}
