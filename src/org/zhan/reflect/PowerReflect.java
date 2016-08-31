package org.zhan.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PowerReflect {
	
	public void getAllMethods(Class<?> clazz) throws Exception {
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(clazz.getName() + "--->" + method.toString());
		}
	}
	
	public void getAllFields(Class<?> clazz) throws Exception {
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			System.out.println(clazz.getName() + "--->" + field.toString() + "=" + field.get(clazz.newInstance()));
		}
	}
	
	public void getAllAnnotations(Class<?> clazz) throws Exception {
		Annotation[] annotations = clazz.getAnnotations();
		for(Annotation annotation : annotations) {
			System.out.println(clazz.getName() + "--->" + annotation.toString());
		}
	}
	
	public static void main(String[] args) throws Exception {
		new PowerReflect().getAllMethods(PowerReflect.class);
		new PowerReflect().getAllFields(PowerReflect.class);
		new PowerReflect().getAllAnnotations(PowerReflect.class);
//		method.invoke(clazz.newInstance(), args);
	}	
}
