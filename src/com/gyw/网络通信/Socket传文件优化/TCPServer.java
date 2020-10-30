package com.gyw.����ͨ��.Socket���ļ��Ż�;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
/**�ļ��ϴ�
 * �����������������ȡ�ͻ�������->����д���ϴ��ļ���������Ӳ��->����д����������д����
 * ����Դ���ͻ�����������
 * Ŀ�ĵأ�������Ӳ�� D:\\upload\1.jps	
 */
public class TCPServer {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//1.ʹ��ServerSocket�Ĺ��췽������ServerSocket���󣬺�ϵͳҪָ���Ķ˿ں�
		ServerSocket server = null;
		try {
			server = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�Ż���ʹ������һֱ���ڼ���״̬�������������ٹر�
		while(true) {
				//2.ʹ��ServerSocket�����accept��������ȡ�ͻ���Socket����
				Socket socket = server.accept();
				//�Ż���ʹ�ö��߳���߷�����Ч��
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							//3.ʹ��Socket�����getInputStream()������ȡ�����ֽ�������InputStream����
							InputStream is = socket.getInputStream();
							//4.�����ж��ļ����Ƿ���ڱ�֤�ļ��ܹ������ɹ�
							File file = new File("D:\\upload");
							if(!file.exists()) {
								file.mkdirs();
							}
							//5.ʹ��FileOutputStream�Ĺ��췽�����������ֽ������FileOutputStream���󣬹��췽����ָ��Ŀ�ĵ�
							//�Ż����Զ����ļ�������ֹ�ļ�������
							String fileName = file+"\\"+System.currentTimeMillis()+new Random().nextInt(9999)+".jps";
							FileOutputStream fos = new FileOutputStream(fileName);
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
						}catch(IOException e) {
							e.printStackTrace();
						}
					}
					
				}).start();
			
			
			
		}
//			server.close();
		
	}
}
