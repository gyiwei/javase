package com.gyw.����������������;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] array = {0,2,4,6,8};
		
		/**
		 * ������̵�����
		 */
		System.out.print("[");
		for (int i=0;i<array.length;i++) {
			if(i == array.length-1) {
				System.out.println(array[i]+"]");
			}else {
				System.out.print(array[i]+", ");	 
			}
		}
		
		/**
		 * �������
		 */
		System.out.println(Arrays.toString(array));

	}

}
