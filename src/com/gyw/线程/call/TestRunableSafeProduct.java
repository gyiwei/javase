package com.gyw.线程.call;
/**
 * 线程安全问题的解决方式1: 同步代码块,锁对象
 * @author Administrator
 *		卖票
 */
public class TestRunableSafeProduct implements Runnable{
	
	static StateRunnable stateRunnable;
	
	public TestRunableSafeProduct(StateRunnable stateRunnable) {
		this.stateRunnable = stateRunnable;
	}
	public TestRunableSafeProduct() {
		super();
	}
	//设置线程任务
	@Override
	public void run() {
		while(true) {
			saleStaticBak();
		}
		
	}
	public static void saleStaticBak() {
		synchronized(stateRunnable) {
			if(stateRunnable.flag == true) {
				try {
					stateRunnable.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(2000);
				System.out.println("2.包子没了，花2秒做好了包子");
				System.out.println("3.通知：包子做好了");
				stateRunnable.flag = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stateRunnable.notify();
			
		}
	}
	
	

}
