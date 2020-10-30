package com.gyw.test3;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		Integer i = 10;
		O o = new O();
		int changeX = changeInt(x);
		Integer changeInteger = changeInteger(i);
		O changeO = changeObject(o);
		System.out.println(x);
		System.out.println(changeX);
		System.out.println(i.hashCode());
		System.out.println(changeInteger.hashCode());
		System.out.println(o.y);
		System.out.println(changeO.y);
		System.out.println(o.hashCode());
		System.out.println(changeO.hashCode());
		System.out.println(o == changeO);
		
		
	}
	public static int changeInt(int x) {
		x = 100;
		return x;
	}
	
	public static Integer changeInteger(Integer x) {
		x = 100;
		return x;
	}
	
	public static O changeObject(O x) {
		x.y = 100;
		return x;
	}
	
	
}

