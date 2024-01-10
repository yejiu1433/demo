package com.demo.common.tcp;

public interface Connection {

	/**
     * 发送信息
     * @param message
     */
     void sendMessage(String message);
 
    /**
     * 接收信息
     * @return
     */
     String receiveMessage();
 
    /**
     * 指定socket资源回收
     */
     void close();
 
    /**
     * 判断数据连接状态
     * @return
     */
     boolean isSocketClosed();


}
