package com.gyw.文件.字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

	public static void main(String[] args){
		try(FileReader in = new FileReader("D:\\demo\\for\\src\\com\\gyw\\文件\\字节流\\测试流2.txt")) {
			/*int len = 0;
			while((len = in.read()) != -1) {
				System.out.println((char)len);
			}*/
			int len = 0;
			char[] cs =new char[1024];
			while((len = in.read(cs)) != -1) {
				System.out.println(new String(cs));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
