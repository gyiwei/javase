package com.gyw.�ļ�.�ֽ���;

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
		FileOutputStream out = new FileOutputStream("D:\\demo\\for\\src\\com\\gyw\\�ļ�\\������.txt",true);
		out.write(97);
		int a = 97;
		out.write(a);
		
		/**
		 * д100
		 */
		// ��3���ֽ�
		out.write(49);
		out.write(48);
		out.write(48);
		//����д�ַ���100ת����bytes
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
		byte[] bytes3 = "��".getBytes(); 
		System.out.println(Arrays.toString(bytes3));//�����ڲ�ͬ������ռ���ֽڲ�ͬ
		byte[] bytes4 = "\r\n".getBytes(); 
		System.out.println(Arrays.toString(bytes4));
		out.close();
	}

}
