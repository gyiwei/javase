package com.gyw.�߳�.call;
/**
 * �̰߳�ȫ����Ľ����ʽ1: ͬ�������,������
 * @author Administrator
 *		��Ʊ
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
