package com.euna;

import java.util.Stack;

public class JavaStacks {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.add("Jin");//calling push internally
        names.push("Mugen");
        names.push("Momo");

        System.out.println(names.size());
        System.out.println(names.peek());
        System.out.println(names.pop());
        System.out.println(names.empty());
    }
}
