package com.gyw.函数式接口;

import java.util.Arrays;

import javax.sound.midi.Soundbank;

public class Test {

	public static void main(String[] args) {
		String msg1 = " hello ";
		String msg2 = " world ";
		String msg3 = " java ";
//		log(1,msg1+msg2+msg3);
//		log(2,msg1+msg2+msg3);//性能浪费，调用log方法 必须拼接好参数
		String[] s = new String[] {"init"};
		String[] s1 = new String[] {"init"};
		String[] s2 = new String[] {"init"};
		System.out.println("初始值："+Arrays.toString(s1));
		//优化 需要打印的字符串通过函数式接口返回
		test(2,new DemoFunctionInterface() {
			@Override
			public String method() {
				s1[0] = msg1+msg2+msg3;
				return msg1+msg2+msg3;
			}
		});
		System.out.println("不满足条件不执行函数式接口的方法："+Arrays.toString(s1));
		//使用labmbda优化函数式接口的实现 匿名内部类
		test(1,() -> {
			s2[0] = msg1+msg2+msg3;
			return msg1+msg2+msg3;
		});
		System.out.println("满足条件执行函数式接口的方法："+Arrays.toString(s2));
		
		test3(1,(msg) -> {
			msg = new String[1];
			msg[0] = msg1+msg2+msg3;
			System.out.println(Arrays.toString(msg));
			return msg;
		});
		
	}
	
	private static void log(int i,String s) {
		System.out.println("进入log方法");
		if(i == 1) {
			System.out.println(s);
		}
	}
	private static void test(int i,DemoFunctionInterface demoFunctionInterface) {
		if(i == 1) {
			System.out.println(demoFunctionInterface.method());
		}
	}
	private static void test3(int i,DemoFunctionInterface2 demoFunctionInterface2) {
		if(i == 1) {
			System.out.println("------------------------");
			demoFunctionInterface2.method();
		}
	}

}
