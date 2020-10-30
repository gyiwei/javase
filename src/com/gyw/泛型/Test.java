package com.gyw.����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * ���Ͳ���
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
		 * ��ͨ��
		 * 		δ������ʱ���Ѿ�ȷ����Ա����������
		 */
		GeneralClass generalClass = new GeneralClass();
		generalClass.setName("δ������ʱ���Ѿ�ȷ����Ա����������");
		System.out.println(generalClass.getName());
	}
	
	public static void test2() {
		/*
		 * ������
		 * 		������ʱ���ȷ����Ա����������
		 */
		GenericClass<String> genericClass = new GenericClass<>();
		genericClass.setName("String");
		System.out.println(genericClass.getName());
		
		GenericClass<Integer> genericClass2 = new GenericClass<>();
		genericClass2.setName(1);
		System.out.println(genericClass2.getName());
		
		//��д����Ĭ��object����
		GenericClass genericClass3 = new GenericClass();
		genericClass3.setName("String");
		Object name = genericClass3.getName();
		System.out.println(name.getClass());
		genericClass3.setName(1);
		Object name2 = genericClass3.getName();
		System.out.println(name2.getClass());
		
	}
	
	public static void test3() {
		GenericMethod.getName("���뷺��");
	}
	
	public static void test4() {
		GenericInterface<String> genericInterfaceImpl = new GenericInterfaceImpl();
		
		GenericInterface<String> genericInterfaceImpl2 = new GenericInterfaceImpl2<String>();
		GenericInterface<Object> genericInterfaceImpl3 = new GenericInterfaceImpl2<Object>();
	
	}
	public static void test5() {
		//�˽�
		ArrayList<Child> a = new ArrayList();
		ArrayList<Me> a2 = new ArrayList();
		ArrayList<Father> a3 = new ArrayList();
		ArrayList<GrandFather> a4 = new ArrayList();
		
		GeneralClass.����ͨ�����������(a);
		GeneralClass.����ͨ�����������(a2);
//		GeneralClass.����ͨ�����������(a3);//�����ĸ��������ͱ�������Ϊ���Ͳ�������
//		GeneralClass.����ͨ�����������(a4);
		
//		GeneralClass.����ͨ�����������(a); //�������ӷ������ͱ�������Ϊ���Ͳ�������
		GeneralClass.����ͨ�����������(a2);
		GeneralClass.����ͨ�����������(a3);
		GeneralClass.����ͨ�����������(a4);
	}
	
	public static void test6() {
		Father f = new Child();
		Child ff = (Child)f;//����ת������
		System.out.println(f.num);
		
		Father f2 = new Me();
//		Child f22 = (Child)f2;//����ת���쳣
		
		Me m = new Child();
		System.out.println(m.num);
		Child c = (Child)m;
		System.out.println(c.num);
	}
	
	public static void test7() {
		Father f = new Child();
		Child ff = (Child)f;//����ת������
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
