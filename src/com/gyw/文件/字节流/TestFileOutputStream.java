package com.gyw.文件.字节流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestFileOutputStream {	
	
	public static void main(String[] args) throws IOException {
		testMkFile();
	}
	
	private static void testMkFile() throws FileNotFoundException {
		FileOutputStream out = new FileOutputStream("D:\\uploadtest\\1.txt");
	}

	private static void testOut() throws FileNotFoundException, IOException {
		FileOutputStream out = new FileOutputStream("D:\\demo\\for\\src\\com\\gyw\\文件\\测试流.txt",true);
		out.write(97);
		int a = 97;
		out.write(a);
		
		/**
		 * 写100
		 */
		// 用3个字节
		out.write(49);
		out.write(48);
		out.write(48);
		//或者写字符串100转换成bytes
		byte[] bytes = "100".getBytes();
		System.out.println(Arrays.toString(bytes));//[49, 48, 48]
		out.write(bytes);
		out.write("\r".getBytes());
		out.write(bytes);
		out.write("\n".getBytes());
		out.write(bytes);
		out.write("\r\n".getBytes());
		out.write(bytes);
		byte[] bytes2 = "a".getBytes();
		System.out.println(Arrays.toString(bytes2));
		byte[] bytes3 = "郭".getBytes(); 
		System.out.println(Arrays.toString(bytes3));//中文在不同编码下占用字节不同
		byte[] bytes4 = "\r\n".getBytes(); 
		System.out.println(Arrays.toString(bytes4));
		out.close();
	}

}
