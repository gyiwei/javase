package com.gyw.文件.字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStream {	
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		FileInputStream in = new FileInputStream("D:\\demo\\for\\src\\com\\gyw\\文件\\字节流\\测试流2.txt");
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
		FileOutputStream out = new FileOutputStream("D:\\demo\\for\\src\\com\\gyw\\文件\\字节流\\测试流3.txt",true);
		//方式1 效率低下
		/*int len = 0;
		while((len=in.read()) != -1) {
			System.out.print(len);
			System.out.print(":");
			System.out.println((char)len);//读取中文乱码
			out.write(len);
		}*/
		//方式2 效率比1高
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
