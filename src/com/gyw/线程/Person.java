package com.gyw.�߳�;

import java.util.Iterator;

public class Person {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person() {
		super();
	}
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(this.name +"\t"+ i);
		}
	}
}
