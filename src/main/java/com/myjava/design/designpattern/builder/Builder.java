package com.myjava.design.designpattern.builder;

public abstract class Builder {
    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getBuildResult();
}
