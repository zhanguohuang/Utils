package org.zhan.callback;

import org.junit.Test;

public class CallBackTest {

	@Test
	public void test() {
		new MyBeanFactory(new MyRegister()).register();
	}
}
