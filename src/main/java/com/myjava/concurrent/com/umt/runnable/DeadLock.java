package com.myjava.concurrent.com.umt.runnable;

public class DeadLock extends Thread{
	
	private static Object obj1 = new Object();
	private static Object obj2 = new Object();
	
	

	public void run() {
		if(this.getName().equals("thread1")){
			synchronized(obj1){
				System.out.println("Thread1 Lock Obj1");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				synchronized(obj2){
					System.out.println("Thread1 Lock Obj2");
				}
			}
		}else if(this.getName().equals("thread2")){
			synchronized(obj2){
				System.out.println("Thread2 Lock Obj2");
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(obj1){
					System.out.println("Thread2 Lock Obj1");
				}
			}
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeadLock thread1 = new DeadLock();
		thread1.setName("thread1");
		thread1.start();
		
		DeadLock thread2 = new DeadLock();
		thread2.setName("thread2");
		thread2.start();
	}

}
