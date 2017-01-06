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
       System.out.println("port = 80 (端口)");
       port = 80; //默认监听80端口
     }

     try{
       serverSocket = new ServerSocket(port); 
       System.out.println("" + serverSocket.getLocalPort());
        
       while(true) { //
         try{
           //
           final Socket socket = serverSocket.accept(); 
           System.out.println(""+
                socket.getInetAddress()+":" + socket.getPort());
          
           service(socket);  //
        }catch(Exception e){e.printStackTrace();} 
      } //#while
    }catch (Exception e) {e.printStackTrace();}
  }

  /** HTTP */
  public static void service(Socket socket)throws Exception{
    InputStream socketIn=socket.getInputStream(); //
    Thread.sleep(1000);  //
    int size=socketIn.available();
    byte[] requestBuffer=new byte[size];
    socketIn.read(requestBuffer);
    String request=new String(requestBuffer);
    System.out.println(request); //
    } 
}
