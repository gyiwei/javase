package com.gyw.����ͨ��.��ʶSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	
	public static void main(String[] args) throws IOException {
		//1.����һ���ͻ���Socket���󣬹��췽���󶨷�����ip�Ͷ˿�
		Socket socket = new Socket("127.0.0.1",8888);
		
		//2.ʹ��Socket�����getOutputStream()������ȡ�����ֽ������OutputStream����
		OutputStream outputStream = socket.getOutputStream();
		//3.ʹ�������ֽ������OutputStream�����write����������������������
		System.out.println("11111111111111111111");
		String msg = "��ã�������";
		outputStream.write(msg.getBytes());
		socket.shutdownOutput();//***�������
		System.out.println("22222222222222222222");
		//4.ʹ��Socket�����getInputStream()������ȡ�����ֽ�������InputStream����
		InputStream is = socket.getInputStream();
		//5.ʹ�û�ȡ�����ֽ�������InputStream�����read��������ȡ�������Ļ�д����
		System.out.println("33333333333333333333");
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=is.read(arr)) != -1) {
			System.out.println(new String(arr,0,len));
		}
		System.out.println("44444444444444444444");
		//6.�ͷ���Դ��socket��
		socket.close();
	}
}
