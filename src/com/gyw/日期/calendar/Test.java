package com.gyw.日期.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历测试类
 */
public class Test {

	public static void main(String[] args) {
		//多态写法 Calendar.getInstance()返回实例
		Calendar calendar = Calendar.getInstance();
		/**
		 * int field:通过Calendar类的静态成员变量获取
		 */
		System.out.println(calendar);
		System.out.println(Calendar.YEAR);
		System.out.println(calendar.get(Calendar.MONTH)+1);
		calendar.set(Calendar.MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.get(Calendar.MONTH)+1);
		Date time = calendar.getTime();
		System.out.println(time);
		System.out.println(System.currentTimeMillis());
	}

}
