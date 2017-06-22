package org.zhan.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zhanguohuang on 2017/6/22.
 */
public interface IHello extends Remote {

    public String helloWorld() throws RemoteException;

}
