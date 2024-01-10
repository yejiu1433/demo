package com.demo.common.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.IOUtils;

public class ClientSocketConnect implements Connection,Runnable{
	
	private Socket socket = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    private DataInputStream inputStream = null;
    // socket输出流
    private DataOutputStream outputStream = null;
    // 获取客户端的ip
    private String clientIp;
    // private String key;
    // private String message;
    
    public ClientSocketConnect(){
    	 
    }
    
    public ClientSocketConnect(Socket socket){
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream(), "UTF-8"));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            clientIp = socket.getInetAddress().getHostAddress();
        } catch (IOException e) {
            System.out.println("客户端连接异常");
            e.printStackTrace();
        }
    }




	@Override
	public void run() {
		//每5秒进行一次客户端连接，判断是否需要释放资源
        while (true){
            try {
                TimeUnit.SECONDS.sleep(5);
                if (isSocketClosed()){
                    System.out.println("客户端已关闭,其IP为："+clientIp);
                    //关闭对应的服务端资源
                    close();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

		
	}

	@Override
	public void sendMessage(String message) {
		System.out.println("服务端发送消息==:"+message);
        try {
            out.write(message);
            out.newLine();
            out.flush();
        } catch (Exception e) {
            System.out.println("发送信息异常：{}");
            close();
        }

	}

	@Override
	public String receiveMessage() {
		try {
            String msg = in.readLine();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }
        return null;
	}

	@Override
	public void close() {
//		log.info("进行资源回收"+clientIp);
		System.out.println("进行资源回收"+clientIp);
        IOUtils.closeQuietly(in);
        IOUtils.closeQuietly(out);
        try {
            this.socket.close();
        } catch (Exception e) {
            System.out.println("close socket get excption："+e);
        }
        System.out.println("ClientSocketConnect----->close 资源回收成功");
		
	}

	@Override
	public boolean isSocketClosed() {
		try {
            //socket.sendUrgentData(1);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write("测试1".getBytes(StandardCharsets.UTF_8));
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            String receive = new String(bytes, "utf-8");
            System.out.println("服务端接收消息===:" + receive);
            return false;
        } catch (Exception e) {
            return true;
        }

	}

}
