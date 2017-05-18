package org.zhan.cglib;

import org.junit.Test;

public class CglibTest {

	@Test
	public void testCglib() {
		ISaySomething iSaySomething = (ISaySomething) new CglibFactory().generatorImpl(ISaySomething.class);
		iSaySomething.say();
	}
}
