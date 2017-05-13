package org.zhan.hex;

import java.io.InputStream;

/**
 * @author zgh
 * @description 将文件以十六进制的形式打印出来
 */
public class Hex {
	
	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for(byte b : data) {
			if(n % 16 == 0) 
				result.append(String.format("%05X: ", n));
			result.append(String.format("%02X ", b)); //前补0 
			n++;
			if(n % 16 == 0) result.append("\n");
		}
		result.append("\n");
		return result.toString();
	}
	
	public static void main(String[] args) throws Exception {
		InputStream in = Hex.class.getClassLoader().getResourceAsStream("org/zhan/hex/Hex.class");
		byte[] b = new byte[in.available()];
		in.read(b);
		System.out.println(format(b));
	}
}
