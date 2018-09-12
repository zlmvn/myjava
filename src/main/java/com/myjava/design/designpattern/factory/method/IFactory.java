package com.myjava.design.designpattern.factory.method;

import com.myjava.design.designpattern.factory.simple.Operation;
import com.myjava.design.designpattern.factory.simple.OperationAdd;
import com.myjava.design.designpattern.factory.simple.OperationDiv;
import com.myjava.design.designpattern.factory.simple.OperationMul;
import com.myjava.design.designpattern.factory.simple.OperationSub;

/**
 * 工厂接口
 * 
 * @author liu yuning
 *
 */
public interface IFactory {
    public Operation createOperation();
}

class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationAdd();
    }

}

class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationSub();
    }

}

class MulFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationMul();
    }

}

class DivFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationDiv();
    }

}