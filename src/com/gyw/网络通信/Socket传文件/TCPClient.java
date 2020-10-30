package com.gyw.����ͨ��.Socket���ļ�;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**�ļ��ϴ�
 * �ͻ��ˣ����ض�����ȡ�ͻ���Ӳ���ļ�->����д���ϴ����ݵ�������->���������ȡ��������д������
 * ����Դ���ͻ���Ӳ�� D:\\test\1.jps
 * Ŀ�ĵأ�������	
 */
public class TCPClient {
	
	public static void main(String[] args) throws IOException {
		//1.ʹ��FileInputStream���������ֽ�������FileInputStream����,���췽���а�����Դ
		FileInputStream fis = new FileInputStream("D:\\test\\1.jps");
		
		//2.����һ���ͻ���Socket���󣬹��췽���󶨷�����ip�Ͷ˿�
		Socket socket = new Socket("127.0.0.1",8888);
		//3.ʹ��Socket�����getOutputStream()������ȡ�����ֽ������OutputStream����
		OutputStream outputStream = socket.getOutputStream();
		/*
		 * �߶���д
		 */
		//4.ʹ�ñ����ֽ�������FileInputStream����read��������ȡ�ͻ���Ӳ���ļ�
		byte[] arr = new byte[1024];
		int len = 0;
		while((len=fis.read(arr)) != -1) {
			//5.ʹ�������ֽ������OutputStream�����write����������������������
			outputStream.write(arr,0,len);
		}
		//***�ϴ���дһ��������� ��Ȼread��һֱ���� ������ѭ��״̬��
		socket.shutdownOutput();
		//6.ʹ��Socket�����getInputStream()������ȡ�����ֽ�������InputStream����
		InputStream is = socket.getInputStream();
		//7.ʹ�û�ȡ�����ֽ�������InputStream�����read��������ȡ�������Ļ�д����
		byte[] arr2 = new byte[1024];
		int len2 = 0;
		while((len2=is.read(arr2)) != -1) {
			System.out.println(new String(arr2,0,len2));
		}
		System.out.println(len2==-1?true:false);
		//8.�ͷ���Դ��Socket,��������
		fis.close();
		socket.close();
	}
}
