package com.gyw.�ӿ�;

public interface DemoInterface extends DemoInterface2,DemoInterface3{
	/**
	 * �ӿڵĳ�Ա����������public static final�ģ����˳����������ʼ��
	 */
	public static final int NUM_1 = 10;
	
	public static final String NUM_2 = "zifuchuan";
	
	/**
	 * ��д��
	 */
	void methodAbstract();
	/**
	 * ����д��
	 */
	public abstract void methodAbstract2();
	/**
	 * defaultĬ�Ϸ�����ʹ�� 
	 * 		ʵ������Բ���д�ӿڵ�Ĭ�Ϸ��������ڽӿ�����
	 */
	public default void methodDefault() {
		System.out.println("jdk1.8֧��default�ӿڷ���");
	};
	/**
	 * static��̬������ʹ��
	 * 		����ͨ��ʵ���������ýӿڵľ�̬����
	 */
	public static void methodStatic() {
		DemoInterface2.methodStatic();
		System.out.println("jdk1.8֧��static�ӿڷ���");
	};
}
