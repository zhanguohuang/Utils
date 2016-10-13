package org.zhan.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 反射获取所有的方法
 * p.matcher中配置了所以以.结尾的字符串并将其替代为""，即删除
 * @author Administrator
 *
 */
public class ShowMethods {
	private static String usage = 
		"usage:\n" + 
		"ShowMethods qualified.class.name\n" +
		"To show all methods in class or\n" +
		"ShowMethods quilified.class.name word\n" +
		"To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	
	/**
	 * 输入className的包名称，能获取到该class的所有方法
	 * @param className
	 */
	public static void showMethods(String className) {
		try {
			Class<?> c = Class.forName(className);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			for(Method method : methods) 
				System.out.println(p.matcher(method.toString()).replaceAll(""));
			for(Constructor ctor : ctors) 
				System.out.println(p.matcher(ctor.toString()).replaceAll(""));
		} catch(ClassNotFoundException e) {
			System.out.println("No such class:" + e);
		}
	}
	
	public static void main(String[] args) {
		/*args = org.chapter14.ShowMethods*/
		if(args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if(args.length == 1) {
				for(Method method : methods) 
					System.out.println(p.matcher(method.toString()).replaceAll(""));
				for(Constructor ctor : ctors) 
					System.out.println(p.matcher(ctor.toString()).replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for(Method method : methods) 
					if(method.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				for(Constructor ctor : ctors) 
					if(ctor.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
			}
		} catch(ClassNotFoundException e) {
			System.out.println("No such class:" + e);
		}
	}
	
}
/**
public static void main(String[])
public final void wait() throws InterruptedException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
*/