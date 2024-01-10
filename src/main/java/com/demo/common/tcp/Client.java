package com.demo.common.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

//	public static void main(String[] args) {
//        String host = "127.0.0.1";

//                           Integer port = 8533 ;
//        try {
//            // 与服务端建立连接
//            Socket socket = new Socket(host, port);
//            socket.setOOBInline(true);
// 
//            // 建立输入输出流
//            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
//            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//            int i = 0;
//            while (true){
//                send("客户发送",outputStream);
//                receive(inputStream);
//                i++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
// 
//    }

	/**
	 * 发送数据
	 * 
	 * @param str
	 * @param outputStream
	 */
	public static void send(String str, DataOutputStream outputStream) throws Exception {
		System.out.println("客户端发送消息：==" + str);
		try {
			outputStream.write(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 接收数据
	 * 
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	public static String receive(DataInputStream inputStream) throws Exception {
		try {
			byte[] bytes = new byte[1024];
			inputStream.read(bytes);
			String info = new String(bytes, "utf-8");
			System.out.println("客户端接收信息：==" + info);
			return info;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
