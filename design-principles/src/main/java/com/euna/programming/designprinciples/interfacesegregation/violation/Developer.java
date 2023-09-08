package com.euna.programming.designprinciples.interfacesegregation.violation;

public class Developer implements Worker{
    @Override
    public void code() {

    }

    @Override
    public void manage() {
    //developer does not need to manage
    }
}
