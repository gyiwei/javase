package com.gyw.A_Stream��;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("��һ");
		list.add("��һһ");
		list.add("��һ");
		list.add("��һһ");
		Stream<String> stream = list.stream();
		Stream<String> stream2 = stream.filter((String name)->{return name.startsWith("��");});
//		System.out.println(stream2.count());//stream has already been operated upon or closed
//		Stream<Integer> map = stream2.map(name ->{return Integer.valueOf(name);});
//		stream2.forEach(name->System.out.println(name));
		List<String> collect = stream2.collect(Collectors.toList());
	}
	private static void listStreamFilter(List<String> list) {
		/*Stream<String> stream = list.stream();
		Stream<String> stream2 = stream.filter((String name)->{return name.startsWith("��");});
		Stream<String> stream3 = stream2.filter(name->name.length()==3);
		stream3.forEach(name->System.out.println(name));*/
		//��ʽ��д
		list.stream()
				.filter((String name)->{return name.startsWith("��");})
				.filter(name->name.length()==3)
				.forEach(name->System.out.println(name));
	}
	/**
	 * ��ͳ��ʽ����
	 */
	@SuppressWarnings("unused")
	private static void filterList(List<String> list) {
		
		List<String> list2 = new ArrayList<>();
		for (String string : list) {
			if(string.startsWith("��")) {
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
