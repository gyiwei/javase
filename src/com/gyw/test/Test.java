package com.gyw.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Administrator
 * @description ˫ð��::   �ӿ�Iterable 8��Ĭ��ʵ����forEach����
 */
public class Test {

	public static void main(String[] args) {
		
		List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
		
		//��ͨд��
		/*for (String str : stooges) {
			 Test.method(str);
		}*/
		
		//��һ�ֱ��
		/*stooges.forEach(str -> {
			 Test.method(str);
		});*/
		
		//˫ð���÷�
		/*Consumer<String> methodParam = Test::method;
		stooges.forEach(str -> methodParam.accept(str));*/
		
		//˫ð�ż��д��
		stooges.forEach(Test::method);
		
		
	}

	
	public static void method(String str) {
		System.out.println(str);
	}
}
