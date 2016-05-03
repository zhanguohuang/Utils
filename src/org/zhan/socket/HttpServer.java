package org.zhan.socket;
import java.io.*;
import java.net.*;
public class HttpServer{
  
  public static void main(String args[]) {
    int port;
    ServerSocket serverSocket;
      
    try { 
       port = Integer.parseInt(args[0]);
     }catch (Exception e) {
       System.out.println("port = 8080 (默认)");
       port = 8080; //默认端口为8080
     }

     try{
       serverSocket = new ServerSocket(port); 
       System.out.println("服务器正在监听端口：" + serverSocket.getLocalPort());
        
       while(true) { //服务器在一个无限循环中不断接收来自客户的TCP连接请求
         try{
           //等待客户的TCP连接请求
           final Socket socket = serverSocket.accept(); 
           System.out.println("建立了与客户的一个新的TCP连接，该客户的地址为："+
                socket.getInetAddress()+":" + socket.getPort());
          
           service(socket);  //响应客户请求
        }catch(Exception e){e.printStackTrace();} 
      } //#while
    }catch (Exception e) {e.printStackTrace();}
  }

  /** 响应客户的HTTP请求 */
  public static void service(Socket socket)throws Exception{
    /*读取HTTP请求信息*/
    InputStream socketIn=socket.getInputStream(); //获得输入流
    Thread.sleep(1000);  //睡眠1秒，等待HTTP请求  
    int size=socketIn.available();
    byte[] requestBuffer=new byte[size];
    socketIn.read(requestBuffer);
    String request=new String(requestBuffer);
    System.out.println(request); //打印HTTP请求数据  
    } 
}
