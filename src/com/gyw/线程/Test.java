package com.gyw.�߳�;

public class Test {

	public static void main(String[] args) {
		
		/*long start = System.currentTimeMillis();
		
		for (int i = 0; i < 1000000; i++) {
			System.out.println("run " +"\t"+ i);
		}
		for (int i = 0; i < 1000000; i++) {
			System.out.println("main " +"\t"+ i);
		}
		long end = System.currentTimeMillis();
		System.out.println("���̺߳�ʱ��"+(end-start));//12282
*/		
		int j = 0;
		while(true) {
			++j;
			System.out.println(j);
			if(j > 9) {
				return;
			}
		}
	}
	
}
