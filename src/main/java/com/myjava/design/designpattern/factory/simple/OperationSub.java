package com.myjava.design.designpattern.factory.simple;

/**
 * 减法类
 * 
 * @author liu yuning
 *
 */
public class OperationSub extends Operation {

    @Override
    public double result() {
	return numberA - numberB;
    }

}