package com.gyw.�߳�;
/**
 * �̰߳�ȫ����Ľ���
 * @author Administrator
 *		��Ʊ
 */
public class TestRunableSafe implements Runnable{
	//����һ��ƱԴ
	private int ticket=8;
	private int i=0;
	public static void main(String[] args) {
		TestRunableSafe runnable = new TestRunableSafe();
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
			if(ticket > 0) {
				//ģ�⣬ʹ���õر�¶�̰߳�ȫ���ֵ����� Thread.sleep�ܹ������ڼ�cpu��ִ��Ȩ
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" ���ۺţ�"+ticket);
				i++;
				--ticket;
				if(ticket == 0) {
					System.out.println("��Ʊ���� "+i+ "");
					return;
				}
			}
		}
		
		
	}
	
	
	

}
