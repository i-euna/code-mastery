package com.euna.programming.designprinciples.interfacesegregation.violation;

public class Manager implements Worker{
    @Override
    public void code() {
        //manager does not need to code
    }

    @Override
    public void manage() {

    }
}
