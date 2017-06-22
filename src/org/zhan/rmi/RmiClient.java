package org.zhan.rmi;

import java.rmi.Naming;

/**
 * Created by zhanguohuang on 2017/6/22.
 */
public class RmiClient {
    public static void main(String[] args) {
        try {
        	IHello rhello = (IHello) Naming.lookup("rmi://localhost:8888/RHello");
            System.out.println("获取远程成功：" + rhello.helloWorld());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
