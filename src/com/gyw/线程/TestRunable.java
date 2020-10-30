package com.gyw.线程;
/**
 * 创建多线程的第二种方式
 * @author Administrator
 *
 */
public class TestRunable implements Runnable{

	public static void main(String[] args) {
		System.out.println("主线程的名称："+Thread.currentThread().getName());//main
		//开启支线程
		/*TestRunable t = new TestRunable();
		Thread thread = new Thread(t);
		thread.start();*/
		
		Thread thread = new Thread(new TestRunable());
		thread.start();
	}
	
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);//Thread[Thread-0,5,main]
	}
	
	
	

}
