package com.gyw.�߳�.call;
/**
 * �̰߳�ȫ����Ľ����ʽ1: ͬ�������,������
 * @author Administrator
 *		��Ʊ
 */
public class Test{
	
	
	public static void main(String[] args) {
		//�����߳������� ��֤Ψһ
		Object obj = new Object();
		

		//�������߳�
		new Thread() {
			//��дrun�����������߳����� �������߳�����
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
				while(true) {
					synchronized(obj) {
						System.out.println("�ȴ�����Ҫ�����");
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("���Ӳ�������Ҫ��");
					}
				}
			}
		}.start();
		
		//�������߳�
		new Thread() {
			//��дrun�����������߳����� �������߳�����
			@Override
			public void run() {
				Thread currentThread = Thread.currentThread();
				System.out.println(currentThread);//Thread[Thread-0,5,main]
				while(true) {
					try {
						Thread.sleep(2000);
						System.out.println("����û�ˣ���2�������˰���");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(obj) {
						System.out.println("֪ͨ������������");
						obj.notify();
					}
				}
			}
		}.start();
		
	}
	
	

}
