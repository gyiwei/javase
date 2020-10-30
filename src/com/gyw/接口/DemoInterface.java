package com.gyw.接口;

public interface DemoInterface extends DemoInterface2,DemoInterface3{
	/**
	 * 接口的成员变量必须是public static final的，成了常量，必须初始化
	 */
	public static final int NUM_1 = 10;
	
	public static final String NUM_2 = "zifuchuan";
	
	/**
	 * 简单写法
	 */
	void methodAbstract();
	/**
	 * 完整写法
	 */
	public abstract void methodAbstract2();
	/**
	 * default默认方法的使用 
	 * 		实现类可以不重写接口的默认方法，利于接口升级
	 */
	public default void methodDefault() {
		System.out.println("jdk1.8支持default接口方法");
	};
	/**
	 * static静态方法的使用
	 * 		不能通过实现类对象调用接口的静态方法
	 */
	public static void methodStatic() {
		DemoInterface2.methodStatic();
		System.out.println("jdk1.8支持static接口方法");
	};
}
