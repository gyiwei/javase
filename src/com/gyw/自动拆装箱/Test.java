package com.gyw.�Զ���װ��;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		/**
		 * װ��	int-Integer 
		 * 		String - Integer
		 * 		���췽��
		 * 		��̬����  valueOf
		 */
		Integer i = new Integer(1);
		Integer i2 = new Integer("1");
//		Integer i3 = new Integer("ab");//java.lang.NumberFormatException
		Integer i4 = Integer.valueOf(1);
		Integer i5 = Integer.valueOf("1");
		Integer integerValue = 1;//�Զ�װ��    �ȼ��� Integer inti = new Integer(1);
		
		/**
		 * ���� Integer-int
		 * 		��Ա���� intValue
		 */
		int int1 = i.intValue();
		int intValue = integerValue;//�Զ�����  �ȼ��� int intValue2 = integerValue.intValue();
		
		//int - String	��̬����toString
		String j = int1+"";
		String k = Integer.toString(int1);
		String k2 = String.valueOf(int1);
		
		//String - int	��̬����parseInt
		int parseInt = Integer.parseInt("1");
		
		/**
		 * ��װ���ʹ��
		 */
//		ArrayList<int> list = new ArrayList<>(); //����д���� �޷�ֱ�Ӵ洢������������
		ArrayList<Integer> list = new ArrayList<>();
		list.add(integerValue);
		list.add(intValue);
	}

}
