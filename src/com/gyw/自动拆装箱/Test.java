package com.gyw.自动拆装箱;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		/**
		 * 装箱	int-Integer 
		 * 		String - Integer
		 * 		构造方法
		 * 		静态方法  valueOf
		 */
		Integer i = new Integer(1);
		Integer i2 = new Integer("1");
//		Integer i3 = new Integer("ab");//java.lang.NumberFormatException
		Integer i4 = Integer.valueOf(1);
		Integer i5 = Integer.valueOf("1");
		Integer integerValue = 1;//自动装箱    等价于 Integer inti = new Integer(1);
		
		/**
		 * 拆箱 Integer-int
		 * 		成员方法 intValue
		 */
		int int1 = i.intValue();
		int intValue = integerValue;//自动拆箱  等价于 int intValue2 = integerValue.intValue();
		
		//int - String	静态方法toString
		String j = int1+"";
		String k = Integer.toString(int1);
		String k2 = String.valueOf(int1);
		
		//String - int	静态方法parseInt
		int parseInt = Integer.parseInt("1");
		
		/**
		 * 包装类的使用
		 */
//		ArrayList<int> list = new ArrayList<>(); //错误写法： 无法直接存储基本数据类型
		ArrayList<Integer> list = new ArrayList<>();
		list.add(integerValue);
		list.add(intValue);
	}

}
