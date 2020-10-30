package com.gyw.线程.safe;
/**
 * 线程安全问题的解决方式2： 同步方法，锁方法
 * @author Administrator
 *		卖票
 */
public class TestRunableSafe2 implements Runnable{
	//定义一个票源
	private int ticket=8;
	private int i=0;
	
	
	////定义一个静态票源
	private static int ticket2=8;
	private static int i2=0;
	
	public static void main(String[] args) {
		TestRunableSafe2 runnable = new TestRunableSafe2();
		System.out.println(runnable);
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
		System.out.println(this);//调用run方法的对象就是TestRunableSafe2
		while(true) {
//			sale();
//			saleBak();
//			saleStatic();
			saleStaticBak();
		}
		
	}
	
	public synchronized void sale() {
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
	}
	
	public void saleBak() {
		synchronized(this) {
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
		}
	}
	
	public static synchronized void saleStatic() {
		if(ticket2 > 0) {
			//模拟，使更好地暴露线程安全出现的问题 Thread.sleep能够放弃期间cpu的执行权
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" 出售号："+ticket2);
			i2++;
			--ticket2;
			if(ticket2 == 0) {
				System.out.println("出票数： "+i2+ "");
			}
		}
	}
	
	public static void saleStaticBak() {
		synchronized(TestRunableSafe2.class) {
			if(ticket2 > 0) {
				//模拟，使更好地暴露线程安全出现的问题 Thread.sleep能够放弃期间cpu的执行权
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 出售号："+ticket2);
				i2++;
				--ticket2;
				if(ticket2 == 0) {
					System.out.println("出票数： "+i2+ "");
				}
			}
		}
	}
}
