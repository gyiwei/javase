package com.gyw.网络通信.Socket的BS结构;

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
/**模拟B/S结构
 * 优化后的结果
 * 目的：通过客户端的访问显示此NewFile.html文件
 * 客户端：用浏览器 模拟B/S结构
 * 
 * 	浏览器地址	http://localhost:8888/src/com/gyw/网络通信/Socket的BS结构/NewFile.html
 *	http://localhost:8888/web/NewFile.html
 * 服务器：
 * 	返回html给浏览器
 *
 * 浏览器解析服务器回写的html，如果有图片，浏览器会单独开启一个线程，读取服务器的图片 (例：favorit.icon	)
 * 
 */
public class BSTCPServer3 {
	
	public static void main(String[] args) throws IOException  {
		//1.使用ServerSocket的构造方法创建ServerSocket对象，和系统要指定的端口号
		ServerSocket server = new ServerSocket(8888);
		while(true) {
			//2.使用ServerSocket对象的accept方法，获取客户端Socket对象
			Socket socket = server.accept();
			new Thread(() -> {
				InputStreamReader isr = null;
				BufferedReader bfis = null;
				FileInputStream fis = null;
				try {
					//3.使用Socket对象的getInputStream()方法获取网络字节输入流InputStream对象
					InputStream is = socket.getInputStream();
					//4.使用获取网络字节输入流InputStream对象的read方法，读取客户端（浏览器）发送的数据
					/*byte[] arr = new byte[1024];
					int len = 0;
					while((len=is.read(arr)) != -1) {
						System.out.println(new String(arr,0,len));
					}*/
					
					//优化 4.使用BufferedReader缓冲流的readLine()方法获取浏览器发送的数据  出现的问题：中文乱码
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
					//获取请求第一行 去掉开头的部分 for/src/com/gyw/网络通信/Socket的BS结构/NewFile.html
					String[] split = line.split(" ");
					String htmlpath = split[1].substring(1);//中文乱码？：for\src\com\gyw\%E7%BD%91%E7%BB%9C%E9%80%9A%E4%BF%A1\Socket%E7%9A%84BS%E7%BB%93%E6%9E%84\NewFile.html (系统找不到指定的路径。)
					System.out.println("*****htmlpath****** "+htmlpath);
					//5.使用FileInputStream创建本地字节输入流FileInputStream对象,构造方法中绑定数据源
//						FileInputStream fis = new FileInputStream("D:\\demo\\for\\src\\com\\gyw\\网络通信\\Socket的BS结构\\NewFile.html");
//						FileInputStream fis = new FileInputStream("D:\\demo\\for\\web\\NewFile.html");
//						FileInputStream fis = new FileInputStream(new File("src\\com\\gyw\\网络通信\\Socket的BS结构\\NewFile.html"));
					//FileInputStream fis = new FileInputStream(new File("src/com/gyw/网络通信/Socket的BS结构/NewFile.html"));
					fis = new FileInputStream(htmlpath);
					//6.使用本地字节输入流FileInputStream对象read方法，读取客户端硬盘文件
					//7.使用Socket对象的getOutputStream()方法获取网络字节输出流OutputStream对象
					OutputStream os = socket.getOutputStream();
					//8.使用网络字节输出流OutputStream对象的write方法，给浏览器回写数据(html)
					/*
					 * html响应头信息 固定写法
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
					//7.释放资源
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
