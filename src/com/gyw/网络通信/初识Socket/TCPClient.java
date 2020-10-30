package com.gyw.网络通信.初识Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	
	public static void main(String[] args) throws IOException {
		//1.创建一个客户端Socket对象，构造方法绑定服务器ip和端口
		Socket socket = new Socket("127.0.0.1",8888);
		
		//2.使用Socket对象的getOutputStream()方法获取网络字节输出流OutputStream对象
		OutputStream outputStream = socket.getOutputStream();
		//3.使用网络字节输出流OutputStream对象的write方法，给服务器发送数据
		System.out.println("11111111111111111111");
		String msg = "你好，服务器";
		outputStream.write(msg.getBytes());
		socket.shutdownOutput();//***解决阻塞
		System.out.println("22222222222222222222");
		//4.使用Socket对象的getInputStream()方法获取网络字节输入流InputStream对象
		InputStream is = socket.getInputStream();
		//5.使用获取网络字节输入流InputStream对象的read方法，读取服务器的回写数据
		System.out.println("33333333333333333333");
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=is.read(arr)) != -1) {
			System.out.println(new String(arr,0,len));
		}
		System.out.println("44444444444444444444");
		//6.释放资源（socket）
		socket.close();
	}
}
