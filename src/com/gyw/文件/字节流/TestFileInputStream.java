package com.gyw.�ļ�.�ֽ���;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStream {	
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		FileInputStream in = new FileInputStream("D:\\demo\\for\\src\\com\\gyw\\�ļ�\\�ֽ���\\������2.txt");
/*		int read = in.read();
		System.out.println(read);
		int read2 = in.read();
		System.out.println(read2);
		int read3 = in.read();
		System.out.println(read3);
		int read4 = in.read();
		System.out.println(read4);
		int read5 = in.read();
		System.out.println(read5);
*/		
		FileOutputStream out = new FileOutputStream("D:\\demo\\for\\src\\com\\gyw\\�ļ�\\�ֽ���\\������3.txt",true);
		//��ʽ1 Ч�ʵ���
		/*int len = 0;
		while((len=in.read()) != -1) {
			System.out.print(len);
			System.out.print(":");
			System.out.println((char)len);//��ȡ��������
			out.write(len);
		}*/
		//��ʽ2 Ч�ʱ�1��
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=in.read(arr)) != -1) {
			System.out.println(new String(arr));
			out.write(arr,0,len);
		}
		
		in.close();
		System.out.println(System.currentTimeMillis()-start);
	}


}
