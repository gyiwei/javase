package com.gyw.线程.call;
/**
 * 线程安全问题的解决方式1: 同步代码块,锁对象
 * @author Administrator
 *		卖票
 */
public class Test2{
	
	
	public static void main(String[] args) {
		StateRunnable s = new StateRunnable();
		
		TestRunableSafeConsume runnable = new TestRunableSafeConsume(s);
		Thread thread = new Thread(runnable);
		thread.start();
		
		TestRunableSafeProduct runnable2 = new TestRunableSafeProduct(s);
		Thread thread2 = new Thread(runnable2);
		thread2.start();
	}
	

}
