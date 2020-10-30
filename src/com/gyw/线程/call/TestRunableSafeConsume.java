package com.gyw.�߳�.call;

import com.gyw.�߳�.safe.TestRunableSafe2;

/**
 * �̰߳�ȫ����Ľ����ʽ1: ͬ�������,������
 * @author Administrator
 *		��Ʊ
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
	//�����߳�����
	@Override
	public void run() {
		/*while(true) {
			saleStaticBak();
		}*/
		while(true) {
			synchronized(stateRunnable) {
				if(stateRunnable.flag == false) {
					System.out.println("1.�ȴ�����Ҫ�����");
					try {
						stateRunnable.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("4.���Ӳ�������Ҫ��");
				stateRunnable.flag = false;
				stateRunnable.notify();
				
			}
		}
		
	}
	/*public static void saleStaticBak() {
		synchronized(stateRunnable) {
			System.out.println("�ȴ�����Ҫ�����");
			try {
				stateRunnable.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���Ӳ�������Ҫ��");
		}
	}*/
	
	

}
