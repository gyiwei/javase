package com.gyw.网络通信.初识Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		//1.使用ServerSocket的构造方法创建ServerSocket对象，和系统要指定的端口号
		ServerSocket server = new ServerSocket(8888);
		//2.使用ServerSocket对象的accept方法，获取客户端Socket对象
		Socket socket = server.accept();
		
		//3.使用Socket对象的getInputStream()方法获取网络字节输入流InputStream对象
		InputStream is = socket.getInputStream();
		//4.使用获取网络字节输入流InputStream对象的read方法，读取客户端发送的数据
		System.out.println("555555555555555555");
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=is.read(arr)) != -1) {
			System.out.println(new String(arr,0,len));
		}
		
		System.out.println("666666666666666666");
		//5.使用Socket对象的getOutputStream()方法获取网络字节输出流OutputStream对象
		OutputStream os = socket.getOutputStream();
		//6.使用网络字节输出流OutputStream对象的write方法，给客户端回写数据
		System.out.println("7777777777777777777");
		String msg = "你也好!!客户端！！";
		os.write(msg.getBytes());
		socket.shutdownOutput();//解决阻塞
		
		System.out.println("8888888888888888888");
		
		//7.释放资源
		socket.close();
		server.close();
	}
}
