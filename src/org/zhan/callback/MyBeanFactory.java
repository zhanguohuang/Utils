package org.zhan.callback;

/**
 * @author zgh
 * @description 职责是创建bean
 */
public class MyBeanFactory {

	private MyRegister register;
	
	public MyBeanFactory(MyRegister register) {
		this.register = register;
	}
	
	public void register() {
		register.register(new CallBackInterface() {
			public void getObject() {
				//回调MyBeanFactory的createBean()
				createBean();
			}
		});
	}
	
	public void createBean() {
		System.out.println("do createBean transaction.");
	}

}
