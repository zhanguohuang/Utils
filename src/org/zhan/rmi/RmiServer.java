package org.zhan.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by zhanguohuang on 2017/6/22.
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            IHello rhello = new HelloImpl();
            //注册端口
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/RHello", rhello);
            System.out.println("远程hello绑定对象成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException  e) {
            e.printStackTrace();
        }
    }
}
