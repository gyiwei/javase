package com.gyw.网络通信.Socket传文件;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**文件上传
 * 客户端：本地读：读取客户端硬盘文件->网络写：上传数据到服务器->网络读：读取服务器回写的数据
 * 数据源：客户端硬盘 D:\\test\1.jps
 * 目的地：服务器	
 */
public class TCPClient {
	
	public static void main(String[] args) throws IOException {
		//1.使用FileInputStream创建本地字节输入流FileInputStream对象,构造方法中绑定数据源
		FileInputStream fis = new FileInputStream("D:\\test\\1.jps");
		
		//2.创建一个客户端Socket对象，构造方法绑定服务器ip和端口
		Socket socket = new Socket("127.0.0.1",8888);
		//3.使用Socket对象的getOutputStream()方法获取网络字节输出流OutputStream对象
		OutputStream outputStream = socket.getOutputStream();
		/*
		 * 边读边写
		 */
		//4.使用本地字节输入流FileInputStream对象read方法，读取客户端硬盘文件
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=fis.read(arr)) != -1) {
			//5.使用网络字节输出流OutputStream对象的write方法，给服务器发送数据
			outputStream.write(arr,0,len);
		}
		//***上传完写一个结束标记 不然read会一直阻塞 处于死循环状态，
		socket.shutdownOutput();
		//6.使用Socket对象的getInputStream()方法获取网络字节输入流InputStream对象
		InputStream is = socket.getInputStream();
		//7.使用获取网络字节输入流InputStream对象的read方法，读取服务器的回写数据
		byte[] arr2 = new byte[1024];
		int len2 = 0;
		while((len2=is.read(arr2)) != -1) {
			System.out.println(new String(arr2,0,len2));
		}
		System.out.println(len2==-1?true:false);
		//8.释放资源（Socket,本地流）
		fis.close();
		socket.close();
	}
}
