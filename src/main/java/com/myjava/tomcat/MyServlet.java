package com.myjava.tomcat;
 

 
public class MyServlet implements MyServletIn {
 
 
	public void service() {
		// TODO Auto-generated method stub
		System.out.println("Hellow I'm the servlet.");
		System.out.println("Now let's start our web http travel.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAOOperator dao = new DAOOperator("Mysql");
		try {
			dao.operate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Now I will beleave the web world...");
		System.out.println("Bye-bye.");
	}
 
}
