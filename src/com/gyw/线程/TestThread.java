package com.gyw.�߳�;
/**
 * �������̵߳ĵ�һ�ַ�ʽ
 * @author Administrator
 *
 */
public class TestThread extends Thread{

	public static void main(String[] args) {
		System.out.println("���̵߳����ƣ�"+Thread.currentThread().getName());//main
		//����֧�߳�
		Thread t = new TestThread();
		t.start();
		
		System.out.println("--------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println("main " +"\t"+ i);
		}
	}
	
	@Override
	public void run() {
		String thredName = this.getName();
		System.out.println("֧�߳����ƣ�"+thredName);//Thread-0
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);//Thread[Thread-0,5,main]
		for (int i = 0; i < 10; i++) {
			System.out.println("run " +"\t"+ i);
		}
	}
	
	
	

}
