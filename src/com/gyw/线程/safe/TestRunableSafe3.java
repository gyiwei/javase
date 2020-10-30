package com.gyw.�߳�.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �̰߳�ȫ����Ľ����ʽ3: Lock
 * @author Administrator
 *		��Ʊ
 */
public class TestRunableSafe3 implements Runnable{
	//����һ��ƱԴ
	private int ticket=8;
	private int i=0;
	//1.����ReentrantLock����
	Lock reentrantLock = new ReentrantLock();
	
	public static void main(String[] args) {
		TestRunableSafe3 runnable = new TestRunableSafe3();
		Thread thread = new Thread(runnable);
		thread.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		Thread thread3 = new Thread(runnable);
		thread3.start();
	}
	//�����߳�����
	//iΪʲô��С��10��ticketΪʲô��С��0?�̰߳�ȫ����
	@Override
	public void run() {
		while(true) {
			//2.��ȡ��
			reentrantLock.lock();
			try {
				if(ticket > 0) {
					//ģ�⣬ʹ���õر�¶�̰߳�ȫ���ֵ����� Thread.sleep�ܹ������ڼ�cpu��ִ��Ȩ
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" ���ۺţ�"+ticket);
					i++;
					--ticket;
					if(ticket == 0) {
						System.out.println("��Ʊ���� "+i+ "");
					}
				}
			} finally {
				//3.�ͷ���
				reentrantLock.unlock();
			}
			
			
		}
		
	}
	
	
	

}
