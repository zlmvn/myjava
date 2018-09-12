package com.myjava.tomcat;
//这里只是模拟数据库操作
public class DAOOperator {
	private String name;
	public DAOOperator(String _name)
	{
		name = _name;
	}
	public void operate() throws InterruptedException
	{
		System.out.println("I will do much work...");
		Thread.sleep(3000);
		System.out.println(name + "DAOOperator exec succeed.");
	}
	
}
