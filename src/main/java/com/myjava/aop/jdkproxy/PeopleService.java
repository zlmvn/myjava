package com.myjava.aop.jdkproxy;

public interface PeopleService
{
	public void save(String name);
	
	public void update(String name,Integer peopleid);
	
	public String getPeopleName(Integer peopleid);
}