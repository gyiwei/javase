package com.gyw.����;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestMap {
	public static void main(String[] args) {
		/**
		 * ��������Ȼ˳������
		 */
		HashMap<String, String> hashMap = new HashMap<String,String>();
		hashMap.put("2", "����2");
		hashMap.put("6", "����6");
		hashMap.put("3", "����3");
		hashMap.put("1", "����1");
		hashMap.put("8", "����8");
		hashMap.put("5", "����5");
		
		System.out.println(hashMap);
		/**
		 * ������˳������
		 */
		HashMap<String, String> linkedHashMap = new LinkedHashMap<String,String>();
		linkedHashMap.put("2", "����2");
		linkedHashMap.put("6", "����6");
		linkedHashMap.put("3", "����3");
		linkedHashMap.put("1", "����1");
		linkedHashMap.put("8", "����8");
		linkedHashMap.put("5", "����5");
		System.out.println(linkedHashMap);
	}
}
