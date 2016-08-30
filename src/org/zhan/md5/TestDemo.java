package org.zhan.md5;

public class TestDemo {

	public static void main(String[] args) {
		String inStr = null;
		//inStr = "00000000000318&M&201605051402511099188&“À»À”Œ&1&20160505&20102&01&http://223.244.227.18:7085/Manage/Pay/HuaRong/Bank/HuaRong_Bank_Notify.aspx&tvT1fgJSg6yY";
		inStr = "tc888888";
		System.out.println(inStr);
		try {
			String str = TDMd5.MD5Sign(inStr);
			//str = str.toUpperCase();
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
