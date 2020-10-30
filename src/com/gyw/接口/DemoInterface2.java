package com.gyw.接口;

public interface DemoInterface2 {
	/**
	 * static静态方法的使用
	 * 		不能通过实现类对象调用接口的静态方法
	 */
	public static void methodStatic() {
		System.out.println("jdk1.8支持static接口方法");
	};
	
	/**
	 * 		jdk1.9才支持private在接口中使用
	 */
//	private void methodDefault() {
//		System.out.println("jdk1.8支持default接口方法");
//	};
}
