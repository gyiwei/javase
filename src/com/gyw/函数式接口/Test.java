package com.gyw.����ʽ�ӿ�;

import java.util.Arrays;

import javax.sound.midi.Soundbank;

public class Test {

	public static void main(String[] args) {
		String msg1 = " hello ";
		String msg2 = " world ";
		String msg3 = " java ";
//		log(1,msg1+msg2+msg3);
//		log(2,msg1+msg2+msg3);//�����˷ѣ�����log���� ����ƴ�Ӻò���
		String[] s = new String[] {"init"};
		String[] s1 = new String[] {"init"};
		String[] s2 = new String[] {"init"};
		System.out.println("��ʼֵ��"+Arrays.toString(s1));
		//�Ż� ��Ҫ��ӡ���ַ���ͨ������ʽ�ӿڷ���
		test(2,new DemoFunctionInterface() {
			@Override
			public String method() {
				s1[0] = msg1+msg2+msg3;
				return msg1+msg2+msg3;
			}
		});
		System.out.println("������������ִ�к���ʽ�ӿڵķ�����"+Arrays.toString(s1));
		//ʹ��labmbda�Ż�����ʽ�ӿڵ�ʵ�� �����ڲ���
		test(1,() -> {
			s2[0] = msg1+msg2+msg3;
			return msg1+msg2+msg3;
		});
		System.out.println("��������ִ�к���ʽ�ӿڵķ�����"+Arrays.toString(s2));
		
		test3(1,(msg) -> {
			msg = new String[1];
			msg[0] = msg1+msg2+msg3;
			System.out.println(Arrays.toString(msg));
			return msg;
		});
		
	}
	
	private static void log(int i,String s) {
		System.out.println("����log����");
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
