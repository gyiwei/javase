package com.gyw.线程;
/**
 * 匿名内部类实现多线程
 * @author Administrator
 *
 */
public class TestNoneName {

	public static void main(String[] args) {
		/**
		 * 方式1
		 */
		Thread thread = new Thread() {
			//重写run方法，设置线程任务
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
		};
		//开启线程任务
		thread.start();
		/**
		 * 方式1的链式简化写法
		 */
		new Thread() {
			//重写run方法，设置线程任务 并开启线程任务
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
		}.start();
		
		
		
		/**
		 * 方式2
		 */
		Runnable runnable = new Runnable() {
			//重写run方法，设置线程任务
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
			
		};
		Thread thread2 = new Thread(runnable);
		//开启线程任务
		thread2.start();
		
		/**
		 * 方式2的链式简化写法
		 */
		new Thread(new Runnable() {
			//重写run方法，设置线程任务
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
		}).start();
		
		/**
		 * jdk8lambda表达式的写法()->{}
		 */
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
		}).start();
	}
	
}
