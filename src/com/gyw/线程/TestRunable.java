package com.gyw.�߳�;
/**
 * �������̵߳ĵڶ��ַ�ʽ
 * @author Administrator
 *
 */
public class TestRunable implements Runnable{

	public static void main(String[] args) {
		System.out.println("���̵߳����ƣ�"+Thread.currentThread().getName());//main
		//����֧�߳�
		/*TestRunable t = new TestRunable();
		Thread thread = new Thread(t);
		thread.start();*/
		
		Thread thread = new Thread(new TestRunable());
		thread.start();
	}
	
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);//Thread[Thread-0,5,main]
	}
	
	
	

}
