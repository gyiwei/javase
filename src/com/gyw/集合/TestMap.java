package com.gyw.集合;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestMap {
	public static void main(String[] args) {
		/**
		 * 按键的自然顺序排序
		 */
		HashMap<String, String> hashMap = new HashMap<String,String>();
		hashMap.put("2", "这是2");
		hashMap.put("6", "这是6");
		hashMap.put("3", "这是3");
		hashMap.put("1", "这是1");
		hashMap.put("8", "这是8");
		hashMap.put("5", "这是5");
		
		System.out.println(hashMap);
		/**
		 * 按键入顺序排序
		 */
		HashMap<String, String> linkedHashMap = new LinkedHashMap<String,String>();
		linkedHashMap.put("2", "这是2");
		linkedHashMap.put("6", "这是6");
		linkedHashMap.put("3", "这是3");
		linkedHashMap.put("1", "这是1");
		linkedHashMap.put("8", "这是8");
		linkedHashMap.put("5", "这是5");
		System.out.println(linkedHashMap);
	}
}
