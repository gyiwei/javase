package com.gyw.日期.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		format(new Date());
		parse("2020-10-16 14:22:29");
	}
	
	private static void format(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format2 = format.format(date);
		System.out.println(format2);
	}
	private static void parse(String date) {
		System.out.println(date);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = null;
		try {
			parse = format.parse(date);
			System.out.println(parse);
			format(parse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 当前到1970-01-01的毫秒
	 */
	private static void test01() {
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date().getTime());
	}
	private static void test02() {
		System.out.println(new Date());
		System.out.println(new Date(0L));
	}

}
