package com.gyw.网络通信.Socket传文件;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**文件上传
 * 服务器：网络读：读取客户端数据->本地写：上传文件到服务器硬盘->网络写：服务器回写数据
 * 数据源：客户端网络数据
 * 目的地：服务器硬盘 D:\\upload\1.jps	
 */
public class TCPServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		//1.使用ServerSocket的构造方法创建ServerSocket对象，和系统要指定的端口号
		ServerSocket server = new ServerSocket(8888);
		//2.使用ServerSocket对象的accept方法，获取客户端Socket对象
		Socket socket = server.accept();
		//3.使用Socket对象的getInputStream()方法获取网络字节输入流InputStream对象
		InputStream is = socket.getInputStream();
		//4.必须判断文件夹是否存在保证文件能够创建成功
		File file = new File("D:\\upload");
		if(!file.exists()) {
			file.mkdirs();
		}
		//5.使用FileOutputStream的构造方法创建本地字节输出流FileOutputStream对象，构造方法中指定目的地
		FileOutputStream fos = new FileOutputStream(file+"\\"+"1.jps");
		/*
		 * 边读边写
		 */
		//6.使用获取网络字节输入流InputStream对象的read方法，读取客户端发送的数据
		byte[] b = new byte[1024];
		int len = 0;
		while((len=is.read(b)) != -1) {
			//7.使用本地字节输出流FileOutputStream对象的write方法，写文件到服务器的硬盘
			fos.write(b, 0, len);
		}
		System.out.println(len==-1?true:false);
		//8.使用Socket对象的getOutputStream()方法获取网络字节输出流OutputStream对象
		OutputStream os = socket.getOutputStream();
		//9.使用网络字节输出流OutputStream对象的write方法，给客户端回写数据
		os.write( "上传成功！ ".getBytes());
		
		//10.释放资源（Socket,本地流，ServerSocket）
		fos.close();
		socket.close();
		server.close();
	}
}
