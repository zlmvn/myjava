package com.myjava.aop.jdkproxy;



public class PeopleServiceBean implements PeopleService
{
	private String user = null;
	
	public PeopleServiceBean(){}
	
	public PeopleServiceBean(String user)
	{
		this.user = user;
	}
	
	public void save(String name)
	{
		System.out.println("我是save()方法");
	}

	public void update(String name, Integer peopleid)
	{
		System.out.println("我是update()方法");
	}

	public String getPeopleName(Integer peopleid)
	{
		System.out.println("我是getPeopleName()方法");
		return "xxx";
	}

	public String getUser()
	{
		return user;
	}
}