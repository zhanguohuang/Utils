package org.zhan.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by zhanguohuang on 2017/6/22.
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloImpl() throws RemoteException {

    }

    @Override
    public String helloWorld() throws RemoteException {
        return "hello world";
    }
}
