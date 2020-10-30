package com.gyw.泛型;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 泛型测试
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		System.out.println(new Test().getClass());
		System.out.println(new Me() instanceof Father);
		System.out.println(new Me() instanceof Child);
	}
	
	public static void test1() {
		/*
		 * 普通类
		 * 		未声明的时候已经确定成员变量的类型
		 */
		GeneralClass generalClass = new GeneralClass();
		generalClass.setName("未声明的时候已经确定成员变量的类型");
		System.out.println(generalClass.getName());
	}
	
	public static void test2() {
		/*
		 * 泛型类
		 * 		声明的时候才确定成员变量的类型
		 */
		GenericClass<String> genericClass = new GenericClass<>();
		genericClass.setName("String");
		System.out.println(genericClass.getName());
		
		GenericClass<Integer> genericClass2 = new GenericClass<>();
		genericClass2.setName(1);
		System.out.println(genericClass2.getName());
		
		//不写泛型默认object类型
		GenericClass genericClass3 = new GenericClass();
		genericClass3.setName("String");
		Object name = genericClass3.getName();
		System.out.println(name.getClass());
		genericClass3.setName(1);
		Object name2 = genericClass3.getName();
		System.out.println(name2.getClass());
		
	}
	
	public static void test3() {
		GenericMethod.getName("传入泛型");
	}
	
	public static void test4() {
		GenericInterface<String> genericInterfaceImpl = new GenericInterfaceImpl();
		
		GenericInterface<String> genericInterfaceImpl2 = new GenericInterfaceImpl2<String>();
		GenericInterface<Object> genericInterfaceImpl3 = new GenericInterfaceImpl2<Object>();
	
	}
	public static void test5() {
		//了解
		ArrayList<Child> a = new ArrayList();
		ArrayList<Me> a2 = new ArrayList();
		ArrayList<Father> a3 = new ArrayList();
		ArrayList<GrandFather> a4 = new ArrayList();
		
		GeneralClass.泛型通配符的上限制(a);
		GeneralClass.泛型通配符的上限制(a2);
//		GeneralClass.泛型通配符的上限制(a3);//参数的父泛型类型被限制作为泛型参数传入
//		GeneralClass.泛型通配符的上限制(a4);
		
//		GeneralClass.泛型通配符的下限制(a); //参数的子泛型类型被限制作为泛型参数传入
		GeneralClass.泛型通配符的下限制(a2);
		GeneralClass.泛型通配符的下限制(a3);
		GeneralClass.泛型通配符的下限制(a4);
	}
	
	public static void test6() {
		Father f = new Child();
		Child ff = (Child)f;//向下转型正常
		System.out.println(f.num);
		
		Father f2 = new Me();
//		Child f22 = (Child)f2;//向下转型异常
		
		Me m = new Child();
		System.out.println(m.num);
		Child c = (Child)m;
		System.out.println(c.num);
	}
	
	public static void test7() {
		Father f = new Child();
		Child ff = (Child)f;//向下转型正常
		ArrayList<Child> list = new ArrayList<>();
		list.add(ff);
		Collections.sort(list, new Comparator<Child>() {
			@Override
			public int compare(Child o1, Child o2) {
				// TODO Auto-generated method stub
				return o1.getNum()-o2.getNum();
			}
		});
		Set<String> set = new TreeSet<>();
	}
}
