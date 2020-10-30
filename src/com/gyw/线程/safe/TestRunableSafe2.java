package com.gyw.�߳�.safe;
/**
 * �̰߳�ȫ����Ľ����ʽ2�� ͬ��������������
 * @author Administrator
 *		��Ʊ
 */
public class TestRunableSafe2 implements Runnable{
	//����һ��ƱԴ
	private int ticket=8;
	private int i=0;
	
	
	////����һ����̬ƱԴ
	private static int ticket2=8;
	private static int i2=0;
	
	public static void main(String[] args) {
		TestRunableSafe2 runnable = new TestRunableSafe2();
		System.out.println(runnable);
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
		System.out.println(this);//����run�����Ķ������TestRunableSafe2
		while(true) {
//			sale();
//			saleBak();
//			saleStatic();
			saleStaticBak();
		}
		
	}
	
	public synchronized void sale() {
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
	}
	
	public void saleBak() {
		synchronized(this) {
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
		}
	}
	
	public static synchronized void saleStatic() {
		if(ticket2 > 0) {
			//ģ�⣬ʹ���õر�¶�̰߳�ȫ���ֵ����� Thread.sleep�ܹ������ڼ�cpu��ִ��Ȩ
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" ���ۺţ�"+ticket2);
			i2++;
			--ticket2;
			if(ticket2 == 0) {
				System.out.println("��Ʊ���� "+i2+ "");
			}
		}
	}
	
	public static void saleStaticBak() {
		synchronized(TestRunableSafe2.class) {
			if(ticket2 > 0) {
				//ģ�⣬ʹ���õر�¶�̰߳�ȫ���ֵ����� Thread.sleep�ܹ������ڼ�cpu��ִ��Ȩ
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" ���ۺţ�"+ticket2);
				i2++;
				--ticket2;
				if(ticket2 == 0) {
					System.out.println("��Ʊ���� "+i2+ "");
				}
			}
		}
	}
}
