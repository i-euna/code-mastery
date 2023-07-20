package com.euna.programming.designprinciples.dry;

//DRY - Don't repeat yourself
public class Dry {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.eatFood();
        cow.moo();

        Human human = new Human();
        human.eatFood();
        human.shout();
    }
}
