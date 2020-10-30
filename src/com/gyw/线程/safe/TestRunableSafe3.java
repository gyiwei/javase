package com.gyw.线程.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全问题的解决方式3: Lock
 * @author Administrator
 *		卖票
 */
public class TestRunableSafe3 implements Runnable{
	//定义一个票源
	private int ticket=8;
	private int i=0;
	//1.定义ReentrantLock对象
	Lock reentrantLock = new ReentrantLock();
	
	public static void main(String[] args) {
		TestRunableSafe3 runnable = new TestRunableSafe3();
		Thread thread = new Thread(runnable);
		thread.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		Thread thread3 = new Thread(runnable);
		thread3.start();
	}
	//设置线程任务
	//i为什么会小于10，ticket为什么会小于0?线程安全问题
	@Override
	public void run() {
		while(true) {
			//2.获取锁
			reentrantLock.lock();
			try {
				if(ticket > 0) {
					//模拟，使更好地暴露线程安全出现的问题 Thread.sleep能够放弃期间cpu的执行权
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" 出售号："+ticket);
					i++;
					--ticket;
					if(ticket == 0) {
						System.out.println("出票数： "+i+ "");
					}
				}
			} finally {
				//3.释放锁
				reentrantLock.unlock();
			}
			
			
		}
		
	}
	
	
	

}
