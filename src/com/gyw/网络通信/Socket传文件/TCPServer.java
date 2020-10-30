package com.gyw.����ͨ��.Socket���ļ�;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**�ļ��ϴ�
 * �����������������ȡ�ͻ�������->����д���ϴ��ļ���������Ӳ��->����д����������д����
 * ����Դ���ͻ�����������
 * Ŀ�ĵأ�������Ӳ�� D:\\upload\1.jps	
 */
public class TCPServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		//1.ʹ��ServerSocket�Ĺ��췽������ServerSocket���󣬺�ϵͳҪָ���Ķ˿ں�
		ServerSocket server = new ServerSocket(8888);
		//2.ʹ��ServerSocket�����accept��������ȡ�ͻ���Socket����
		Socket socket = server.accept();
		//3.ʹ��Socket�����getInputStream()������ȡ�����ֽ�������InputStream����
		InputStream is = socket.getInputStream();
		//4.�����ж��ļ����Ƿ���ڱ�֤�ļ��ܹ������ɹ�
		File file = new File("D:\\upload");
		if(!file.exists()) {
			file.mkdirs();
		}
		//5.ʹ��FileOutputStream�Ĺ��췽�����������ֽ������FileOutputStream���󣬹��췽����ָ��Ŀ�ĵ�
		FileOutputStream fos = new FileOutputStream(file+"\\"+"1.jps");
		/*
		 * �߶���д
		 */
		//6.ʹ�û�ȡ�����ֽ�������InputStream�����read��������ȡ�ͻ��˷��͵�����
		byte[] b = new byte[1024];
		int len = 0;
		while((len=is.read(b)) != -1) {
			//7.ʹ�ñ����ֽ������FileOutputStream�����write������д�ļ�����������Ӳ��
			fos.write(b, 0, len);
		}
		System.out.println(len==-1?true:false);
		//8.ʹ��Socket�����getOutputStream()������ȡ�����ֽ������OutputStream����
		OutputStream os = socket.getOutputStream();
		//9.ʹ�������ֽ������OutputStream�����write���������ͻ��˻�д����
		os.write( "�ϴ��ɹ��� ".getBytes());
		
		//10.�ͷ���Դ��Socket,��������ServerSocket��
		fos.close();
		socket.close();
		server.close();
	}
}
