package com.gyw.文件.字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile {	
	//	/for/src/com/gyw/文件/字节流/TestFile.java
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("\\for\\web\\NewFile.html");
		/*testPathSeparator();
		
		testSeparator();
		
		testCopy();*/
	}
	private static void testCopy() {
		FileInputStream in = null;
		
		try {
			in = new FileInputStream("D:\\demo\\for\\src\\com\\gyw\\文件\\字节流\\测试流2.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("D:\\demo\\for\\src\\com\\gyw\\文件\\字节流\\测试流4.txt",true);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		byte[] arr = new byte[1024];
		int len = 0;
		try {
			while((len=in.read(arr)) != -1) {
				System.out.println(new String(arr));
				out.write(arr,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/*
	 * 优化
	 */
	private static void testCopy2() {
		try(FileInputStream in = new FileInputStream("D:\\demo\\for\\src\\com\\gyw\\文件\\字节流\\测试流2.txt");FileOutputStream out = new FileOutputStream("D:\\demo\\for\\src\\com\\gyw\\文件\\字节流\\测试流4.txt",true);) {
			byte[] arr = new byte[1024];
			int len = 0;
			while((len=in.read(arr)) != -1) {
				System.out.println(new String(arr));
				out.write(arr,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	//路径分隔符：系统中多个程序路径之间的分隔符
	private static void testSeparator() {
		String separator = File.separator;
		System.out.println(separator);// windows下是分号(;)；linux下是冒号(:)
	}
	//名称分隔符：系统中单个程序文件夹层级分隔符
	private static void testPathSeparator() {
		String pathseparator = File.pathSeparator;
		System.out.println(pathseparator);// windows下是反斜杠(\)；linux下是正斜杠(/)
	}
}
