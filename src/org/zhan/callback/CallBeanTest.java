package org.zhan.callback;

import org.junit.Test;

public class CallBeanTest {

	@Test
	public void test() {
		new MyBeanFactory(new MyRegister()).register();
	}
}
