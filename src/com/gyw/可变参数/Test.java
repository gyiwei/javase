package com.gyw.可变参数;
/**
 * 当方法的参数列表的数据类型确定，参数个数不确定时使用可变参数
 * 		一个方法最多只能有一个可变参数，如果方法的参数有多个，可变参数只能在参数列表的末尾
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = sum(1,2,3);
	}

	private static int sum(int...param) {
		//[I@15db9742 : [ 表示为数组，I 表示为int @15db9742 表示模拟地址
		System.out.println("param："+param);//可变参底层是数组，传几个参数就会 new int[param.length]
		System.out.println("可变参的长度："+param.length);
		Integer result = 0;
		for (int i : param) {
			System.out.println(i);
			result = i+result;
		}
		System.out.println("求和结果："+result);
		return result;
	}
	
	

}
