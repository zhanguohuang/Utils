package org.zhan.callback;

public class MyRegister {

	public void register(CallBackInterface callback) {
		System.out.println("do something register before");
		callback.getObject();
		System.out.println("do something register after : register this bean");
	}
}
