package com.gyw.线程.call;

import com.gyw.线程.safe.TestRunableSafe2;

/**
 * 线程安全问题的解决方式1: 同步代码块,锁对象
 * @author Administrator
 *		卖票
 */
public class TestRunableSafeConsume implements Runnable{
	
//	static StateRunnable stateRunnable;
	StateRunnable stateRunnable;
	
	public TestRunableSafeConsume(StateRunnable stateRunnable) {
		this.stateRunnable = stateRunnable;
	}
	public TestRunableSafeConsume() {
		super();
	}
	//设置线程任务
	@Override
	public void run() {
		/*while(true) {
			saleStaticBak();
		}*/
		while(true) {
			synchronized(stateRunnable) {
				if(stateRunnable.flag == false) {
					System.out.println("1.等待：我要买包子");
					try {
						stateRunnable.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("4.包子不够，还要！");
				stateRunnable.flag = false;
				stateRunnable.notify();
				
			}
		}
		
	}
	/*public static void saleStaticBak() {
		synchronized(stateRunnable) {
			System.out.println("等待：我要买包子");
			try {
				stateRunnable.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("包子不够，还要！");
		}
	}*/
	
	

}
