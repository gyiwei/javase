package com.gyw.����ͨ��.��ʶSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		//1.ʹ��ServerSocket�Ĺ��췽������ServerSocket���󣬺�ϵͳҪָ���Ķ˿ں�
		ServerSocket server = new ServerSocket(8888);
		//2.ʹ��ServerSocket�����accept��������ȡ�ͻ���Socket����
		Socket socket = server.accept();
		
		//3.ʹ��Socket�����getInputStream()������ȡ�����ֽ�������InputStream����
		InputStream is = socket.getInputStream();
		//4.ʹ�û�ȡ�����ֽ�������InputStream�����read��������ȡ�ͻ��˷��͵�����
		System.out.println("555555555555555555");
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=is.read(arr)) != -1) {
			System.out.println(new String(arr,0,len));
		}
		
		System.out.println("666666666666666666");
		//5.ʹ��Socket�����getOutputStream()������ȡ�����ֽ������OutputStream����
		OutputStream os = socket.getOutputStream();
		//6.ʹ�������ֽ������OutputStream�����write���������ͻ��˻�д����
		System.out.println("7777777777777777777");
		String msg = "��Ҳ��!!�ͻ��ˣ���";
		os.write(msg.getBytes());
		socket.shutdownOutput();//�������
		
		System.out.println("8888888888888888888");
		
		//7.�ͷ���Դ
		socket.close();
		server.close();
	}
}
