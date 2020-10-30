package com.gyw.A_Stream流;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("张一");
		list.add("张一一");
		list.add("李一");
		list.add("李一一");
		Stream<String> stream = list.stream();
		Stream<String> stream2 = stream.filter((String name)->{return name.startsWith("张");});
//		System.out.println(stream2.count());//stream has already been operated upon or closed
//		Stream<Integer> map = stream2.map(name ->{return Integer.valueOf(name);});
//		stream2.forEach(name->System.out.println(name));
		List<String> collect = stream2.collect(Collectors.toList());
	}
	private static void listStreamFilter(List<String> list) {
		/*Stream<String> stream = list.stream();
		Stream<String> stream2 = stream.filter((String name)->{return name.startsWith("张");});
		Stream<String> stream3 = stream2.filter(name->name.length()==3);
		stream3.forEach(name->System.out.println(name));*/
		//链式书写
		list.stream()
				.filter((String name)->{return name.startsWith("张");})
				.filter(name->name.length()==3)
				.forEach(name->System.out.println(name));
	}
	/**
	 * 传统方式过滤
	 */
	@SuppressWarnings("unused")
	private static void filterList(List<String> list) {
		
		List<String> list2 = new ArrayList<>();
		for (String string : list) {
			if(string.startsWith("张")) {
				list2.add(string);
			}
		}
		List<String> list3 = new ArrayList<>();
		for (String string : list2) {
			if(string.length() == 3) {
				list3.add(string);
			}
		}
		
		System.out.println(list3);
	}
	
}
