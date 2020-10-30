package com.gyw.����ͨ��.Socket��BS�ṹ;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
/**ģ��B/S�ṹ
 * �Ż���Ľ��
 * Ŀ�ģ�ͨ���ͻ��˵ķ�����ʾ��NewFile.html�ļ�
 * �ͻ��ˣ�������� ģ��B/S�ṹ
 * 
 * 	�������ַ	http://localhost:8888/src/com/gyw/����ͨ��/Socket��BS�ṹ/NewFile.html
 *	http://localhost:8888/web/NewFile.html
 * ��������
 * 	����html�������
 *
 * �����������������д��html�������ͼƬ��������ᵥ������һ���̣߳���ȡ��������ͼƬ (����favorit.icon	)
 * 
 */
public class BSTCPServer3 {
	
	public static void main(String[] args) throws IOException  {
		//1.ʹ��ServerSocket�Ĺ��췽������ServerSocket���󣬺�ϵͳҪָ���Ķ˿ں�
		ServerSocket server = new ServerSocket(8888);
		while(true) {
			//2.ʹ��ServerSocket�����accept��������ȡ�ͻ���Socket����
			Socket socket = server.accept();
			new Thread(() -> {
				InputStreamReader isr = null;
				BufferedReader bfis = null;
				FileInputStream fis = null;
				try {
					//3.ʹ��Socket�����getInputStream()������ȡ�����ֽ�������InputStream����
					InputStream is = socket.getInputStream();
					//4.ʹ�û�ȡ�����ֽ�������InputStream�����read��������ȡ�ͻ��ˣ�����������͵�����
					/*byte[] arr = new byte[1024];
					int len = 0;
					while((len=is.read(arr)) != -1) {
						System.out.println(new String(arr,0,len));
					}*/
					
					//�Ż� 4.ʹ��BufferedReader��������readLine()������ȡ��������͵�����  ���ֵ����⣺��������
					//InputStreamReader isr = new InputStreamReader(is,"UTF-8");
					isr = new InputStreamReader(is);
					bfis = new BufferedReader(isr);
					/*StringBuilder sb = new StringBuilder();
					String line = null;
					while((line=bfis.readLine()) != null) {
						sb.append(line);
					}
					String[] split = sb.toString().split(" ");
					for (String string : split) {
						System.out.println(string);
					}*/
//						String line = bfis.readLine();
					String line = URLDecoder.decode(bfis.readLine(),"UTF-8");
					System.out.println("*****line****** "+line);
					//��ȡ�����һ�� ȥ����ͷ�Ĳ��� for/src/com/gyw/����ͨ��/Socket��BS�ṹ/NewFile.html
					String[] split = line.split(" ");
					String htmlpath = split[1].substring(1);//�������룿��for\src\com\gyw\%E7%BD%91%E7%BB%9C%E9%80%9A%E4%BF%A1\Socket%E7%9A%84BS%E7%BB%93%E6%9E%84\NewFile.html (ϵͳ�Ҳ���ָ����·����)
					System.out.println("*****htmlpath****** "+htmlpath);
					//5.ʹ��FileInputStream���������ֽ�������FileInputStream����,���췽���а�����Դ
//						FileInputStream fis = new FileInputStream("D:\\demo\\for\\src\\com\\gyw\\����ͨ��\\Socket��BS�ṹ\\NewFile.html");
//						FileInputStream fis = new FileInputStream("D:\\demo\\for\\web\\NewFile.html");
//						FileInputStream fis = new FileInputStream(new File("src\\com\\gyw\\����ͨ��\\Socket��BS�ṹ\\NewFile.html"));
					//FileInputStream fis = new FileInputStream(new File("src/com/gyw/����ͨ��/Socket��BS�ṹ/NewFile.html"));
					fis = new FileInputStream(htmlpath);
					//6.ʹ�ñ����ֽ�������FileInputStream����read��������ȡ�ͻ���Ӳ���ļ�
					//7.ʹ��Socket�����getOutputStream()������ȡ�����ֽ������OutputStream����
					OutputStream os = socket.getOutputStream();
					//8.ʹ�������ֽ������OutputStream�����write���������������д����(html)
					/*
					 * html��Ӧͷ��Ϣ �̶�д��
					 */
					os.write("HTTP/1.1 200 OK\r\n".getBytes());
					os.write("Content-Type:text/html\r\n".getBytes());
					os.write("\r\n".getBytes());
					byte[] bytes = new byte[1024];
					int len2 = 0;
					while((len2=fis.read(bytes)) != -1) {
						os.write(bytes, 0, len2);
					}
					
				}catch(IOException e) {
					System.out.println(e.getMessage());
				}finally {
					//7.�ͷ���Դ
					try {
						isr.close();
						bfis.close();
						fis.close();
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			}).start(); 
		}
		
		
//		server.close();
		
	}
}
