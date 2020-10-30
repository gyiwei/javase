package com.gyw.线程.call;
/**
 * 线程安全问题的解决方式1: 同步代码块,锁对象
 * @author Administrator
 *		卖票
 */
public class Test{
	
	
	public static void main(String[] args) {
		//创建线程锁对象 保证唯一
		Object obj = new Object();
		

		//消费者线程
		new Thread() {
			//重写run方法，设置线程任务 并开启线程任务
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
				while(true) {
					synchronized(obj) {
						System.out.println("等待：我要买包子");
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("包子不够，还要！");
					}
				}
			}
		}.start();
		
		//生产者线程
		new Thread() {
			//重写run方法，设置线程任务 并开启线程任务
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
				while(true) {
					try {
						Thread.sleep(2000);
						System.out.println("包子没了，花2秒做好了包子");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(obj) {
						System.out.println("通知：包子做好了");
						obj.notify();
					}
				}
			}
		}.start();
		
	}
	
	

}
