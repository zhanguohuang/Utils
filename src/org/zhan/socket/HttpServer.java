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
       System.out.println("port = 8080 (Ĭ��)");
       port = 8080; //Ĭ�϶˿�Ϊ8080
     }

     try{
       serverSocket = new ServerSocket(port); 
       System.out.println("���������ڼ����˿ڣ�" + serverSocket.getLocalPort());
        
       while(true) { //��������һ������ѭ���в��Ͻ������Կͻ���TCP��������
         try{
           //�ȴ��ͻ���TCP��������
           final Socket socket = serverSocket.accept(); 
           System.out.println("��������ͻ���һ���µ�TCP���ӣ��ÿͻ��ĵ�ַΪ��"+
                socket.getInetAddress()+":" + socket.getPort());
          
           service(socket);  //��Ӧ�ͻ�����
        }catch(Exception e){e.printStackTrace();} 
      } //#while
    }catch (Exception e) {e.printStackTrace();}
  }

  /** ��Ӧ�ͻ���HTTP���� */
  public static void service(Socket socket)throws Exception{
    /*��ȡHTTP������Ϣ*/
    InputStream socketIn=socket.getInputStream(); //���������
    Thread.sleep(1000);  //˯��1�룬�ȴ�HTTP����  
    int size=socketIn.available();
    byte[] requestBuffer=new byte[size];
    socketIn.read(requestBuffer);
    String request=new String(requestBuffer);
    System.out.println(request); //��ӡHTTP��������  
    } 
}
