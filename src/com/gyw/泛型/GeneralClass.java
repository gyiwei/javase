package com.gyw.����;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ��ͨ�� ����ͨ�������ʹ��
 * @author Administrator
 *
 */
public class GeneralClass {
	
	private String name;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("e");
//		forIntegerList(list1);
		forStringList(list1);
//		forObjectList(list1);
		forAllList(list1);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		forIntegerList(list2);
//		forStringList(list2);
//		forObjectList(list2);
		forAllList(list2);
		
		//
		List<?> list3 = new ArrayList<>();
		forAllList(list3);
	}	
	
	public static void forIntegerList(List<Integer> list) {
		
	}
	public static void forStringList(List<String> list) {
		
	}
	public static void forObjectList(List<Object> list) {
		
	}
	/**
	 * ����ͨ���?��ʹ��
	 * @param list
	 */
	public static void forAllList(List<?> list) {
		Iterator<?> iterator = list.iterator();
		while(iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
	}
	/**
	 * ֻ�ܴ���Me�����ҵ�������Ϊ����
	 * @param list
	 */
	public static void ����ͨ�����������(ArrayList<? extends Me> list) {
		
	}
	
	/**
	 * ֻ�ܴ���Me�����ҵĳ�����Ϊ����
	 * @param list
	 */
	public static void ����ͨ�����������(ArrayList<? super Me> list) {
		
	}
	
}
