package com.gyw.�ӿ�.impl;

import com.gyw.�ӿ�.DemoInterface;
import com.gyw.�ӿ�.DemoInterface2;

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
