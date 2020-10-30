package com.gyw.线程;
/**
 * 创建多线程的第一种方式
 * @author Administrator
 *
 */
public class TestThread extends Thread{

	public static void main(String[] args) {
		System.out.println("主线程的名称："+Thread.currentThread().getName());//main
		//开启支线程
		Thread t = new TestThread();
		t.start();
		
		System.out.println("--------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println("main " +"\t"+ i);
		}
	}
	
	@Override
	public void run() {
		String thredName = this.getName();
		System.out.println("支线程名称："+thredName);//Thread-0
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);//Thread[Thread-0,5,main]
		for (int i = 0; i < 10; i++) {
			System.out.println("run " +"\t"+ i);
		}
	}
	
	
	

}
