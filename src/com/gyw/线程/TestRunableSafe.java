package com.gyw.线程;
/**
 * 线程安全问题的解释
 * @author Administrator
 *		卖票
 */
public class TestRunableSafe implements Runnable{
	//定义一个票源
	private int ticket=8;
	private int i=0;
	public static void main(String[] args) {
		TestRunableSafe runnable = new TestRunableSafe();
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
			if(ticket > 0) {
				//模拟，使更好地暴露线程安全出现的问题 Thread.sleep能够放弃期间cpu的执行权
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 出售号："+ticket);
				i++;
				--ticket;
				if(ticket == 0) {
					System.out.println("出票数： "+i+ "");
					return;
				}
			}
		}
		
		
	}
	
	
	

}
