package com.gyw.接口.impl;

import com.gyw.接口.DemoInterface;
import com.gyw.接口.DemoInterface2;

public class DemoImpl implements DemoInterface,DemoInterface2{
	public static void main(String[] args) {
		DemoInterface a = new DemoImpl();
//		a.method3();
//		a.myMethod();
		System.out.println(a);
		DemoImpl b = new DemoImpl();
		System.out.println(b);
		b.myMethod();
	}
	public void myMethod() {
		DemoInterface a = new DemoImpl();
//		a.method3();
		DemoInterface.methodStatic();
	}

	@Override
	public void methodAbstract() {
		
	}

	@Override
	public void methodAbstract2() {
		
	}
	@Override
	public void methodStatic3() {
		// TODO Auto-generated method stub
		
	}
	
}
