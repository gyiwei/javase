package com.gyw.�ɱ����;
/**
 * �������Ĳ����б����������ȷ��������������ȷ��ʱʹ�ÿɱ����
 * 		һ���������ֻ����һ���ɱ��������������Ĳ����ж�����ɱ����ֻ���ڲ����б��ĩβ
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = sum(1,2,3);
	}

	private static int sum(int...param) {
		//[I@15db9742 : [ ��ʾΪ���飬I ��ʾΪint @15db9742 ��ʾģ���ַ
		System.out.println("param��"+param);//�ɱ�εײ������飬�����������ͻ� new int[param.length]
		System.out.println("�ɱ�εĳ��ȣ�"+param.length);
		Integer result = 0;
		for (int i : param) {
			System.out.println(i);
			result = i+result;
		}
		System.out.println("��ͽ����"+result);
		return result;
	}
	
	

}
