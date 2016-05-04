package org.zhan.md5;

import java.security.MessageDigest;

public class TDMd5 {
	public static String MD5Sign(String inStr) throws Exception{
		MessageDigest md5 = null;
		md5 = MessageDigest.getInstance("MD5");
		md5.update(inStr.getBytes("UTF-8"));
		String sign = byte2hex(md5.digest());
		return sign;
	}
	public static String byte2hex(byte[] bytes){
		StringBuilder sign = new StringBuilder();
		for(int i=0;i<bytes.length;i++){
			String hex = Integer.toHexString(bytes[i]&0xFF);
			if(hex.length() == 1){
				sign.append("0");
			}
			sign.append(hex);
		}
		return sign.toString();
	}
}
