package com.demo.common.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SocketServer {
	
	final static Logger log = LoggerFactory.getLogger(SocketServer .class);
    @Value("${socket.port}")
    private Integer port;
    private boolean started;
    private ServerSocket serverSocket;
    private ExecutorService executorService = Executors.newCachedThreadPool();
 
    public void start(Integer port){
        log.info("port: {}, {}", this.port, port);
        try {
            serverSocket =  new ServerSocket(port == null ? this.port : port);
            started = true;
            log.info("Socket服务已启动，占用端口： {}", serverSocket.getLocalPort());
        } catch (IOException e) {
            log.error("端口冲突,异常信息：{}", e);
            System.exit(0);
        }
 
        try {
            while (started) {
                // 接收并等待客户端连接，返回客户端套接字
                Socket socket = serverSocket.accept();
                // 维持连接-长连接
                socket.setKeepAlive(true);
                ClientSocketConnect socketConnect = new ClientSocketConnect(socket);
                Thread thread = new Thread(socketConnect);
                executorService.execute(thread);
 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
