package com.gyw.�߳�.call;
/**
 * �̰߳�ȫ����Ľ����ʽ1: ͬ�������,������
 * @author Administrator
 *		��Ʊ
 */
public class TestRunableSafeProduct implements Runnable{
	
	static StateRunnable stateRunnable;
	
	public TestRunableSafeProduct(StateRunnable stateRunnable) {
		this.stateRunnable = stateRunnable;
	}
	public TestRunableSafeProduct() {
		super();
	}
	//�����߳�����
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
				System.out.println("2.����û�ˣ���2�������˰���");
				System.out.println("3.֪ͨ������������");
				stateRunnable.flag = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stateRunnable.notify();
			
		}
	}
	
	

}
