package com.gyw.�߳�;
/**
 * �����ڲ���ʵ�ֶ��߳�
 * @author Administrator
 *
 */
public class TestNoneName {

	public static void main(String[] args) {
		/**
		 * ��ʽ1
		 */
		Thread thread = new Thread() {
			//��дrun�����������߳�����
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
		};
		//�����߳�����
		thread.start();
		/**
		 * ��ʽ1����ʽ��д��
		 */
		new Thread() {
			//��дrun�����������߳����� �������߳�����
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
		}.start();
		
		
		
		/**
		 * ��ʽ2
		 */
		Runnable runnable = new Runnable() {
			//��дrun�����������߳�����
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
			
		};
		Thread thread2 = new Thread(runnable);
		//�����߳�����
		thread2.start();
		
		/**
		 * ��ʽ2����ʽ��д��
		 */
		new Thread(new Runnable() {
			//��дrun�����������߳�����
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
			}
		}).start();
		
		/**
		 * jdk8lambda���ʽ��д��()->{}
		 */
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName());
		}).start();
	}
	
}
