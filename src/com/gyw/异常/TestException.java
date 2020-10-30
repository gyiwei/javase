package com.gyw.异常;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestException{

	/*public static void main(String[] args) throws MyException {
		test01 ();
		System.out.println("houxu代码得不到执行");
	}*/
	/*public static void main(String[] args){
		test01bak ();
		System.out.println("houxu代码");
	}*/
	public static void main(String[] args){
		
		test04("a");
	}
	
	/*
	 * throws关键字的使用
	 */
	private static void test01() throws MyException{
		throw new MyException();
	}
	
	private static void test01bak(){
		try {
			throw new MyException();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * throw 关键字的使用
	 */
	public static void test02(String dateStr) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
			String format2 = format.format(new Date());
			Date parse = format.parse(dateStr);
		} catch (Exception e) {
			throw new MyRuntimeException("日期格式解析错误");
		}
	}
	public static void test02bak (String dateStr) {
		// TODO Auto-generated method stub
		throw new MyRuntimeException("日期格式解析错误");
		
	}
	
	/**
	 * try catch
	 */
	public static void test03 () {
		int arr[] = {1,2,3};
		System.out.println(arr[3]);
		List<String> list = new ArrayList<>();
		list.add("1");
		System.out.println(list.get(1));
	}
	public static String test04 (String s) {
		String result= null;
		try {
			String a ="a";
			if(a == s) {
				result = "有权限";
				System.out.println("添加注册逻辑");
				for (int i = 0; i < 5; i++) {
					System.out.println("添加"+i);
				}
			}else {
				result = "没有权限";
				throw new MyException(result);
			}
			
		} catch (MyException e) {
			System.out.println("catch");
		} finally {
			System.out.println("释放资源");
		}
		System.out.println("结束判断");
		return result;
		
	}
	
	
}
