package com.gyw.����.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * ����������
 */
public class Test {

	public static void main(String[] args) {
		//��̬д�� Calendar.getInstance()����ʵ��
		Calendar calendar = Calendar.getInstance();
		/**
		 * int field:ͨ��Calendar��ľ�̬��Ա������ȡ
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
