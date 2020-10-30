package com.gyw.面向过程与面向对象;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] array = {0,2,4,6,8};
		
		/**
		 * 面向过程的做法
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
		 * 面向对象
		 */
		System.out.println(Arrays.toString(array));

	}

}
