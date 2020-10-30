package com.gyw.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Administrator
 * @description 双冒号::   接口Iterable 8中默认实现了forEach方法
 */
public class Test {

	public static void main(String[] args) {
		
		List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
		
		//普通写法
		/*for (String str : stooges) {
			 Test.method(str);
		}*/
		
		//另一种表达
		/*stooges.forEach(str -> {
			 Test.method(str);
		});*/
		
		//双冒号用法
		/*Consumer<String> methodParam = Test::method;
		stooges.forEach(str -> methodParam.accept(str));*/
		
		//双冒号简洁写法
		stooges.forEach(Test::method);
		
		
	}

	
	public static void method(String str) {
		System.out.println(str);
	}
}
