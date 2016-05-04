package org.zhan.md5;

public class TestMD5 {
	public static void main(String args[]){
		String MD5key; //[必填]MD5key值为您在新付支付注册后所得、需要您向业务人员获取
	    MD5key = "9fKfnmt9zga1";

	    String MerNo;   //[必填]商户ID为您在新付支付注册后所、需要您向业务人员获取
	    MerNo = "00000000000078";
	     
		String	Signtype; // [必填]加密方式 目前只为M
	    Signtype = "M"; 
			
		String Prdordno;  // [必填]订单编号 
	    Prdordno = "P201525432526395";

		String	bizType; //[必填]商户业务类型为您在新付支付注册时候设定
	    bizType = "10"; 
			
		String	Prdordnam; //[必填]商品名称
	    Prdordnam = "testproduct"; 
	    
	    String Ordamt;  // [必填]支付金额【以分为单位】
	    Ordamt = "121"; 
	    
		String	Orddate; // [必填]下单日期交易时间：YYYYMMDD
	    Orddate = "20151105"; 
			
		String	TranType; //[必填]交易类型
	    TranType = "20102";     
	    
	    String Paytype;  //[必填]支付方式
	    Paytype = "01"; 
	    
		String	bankCode ; // [必填]银行编码
	    bankCode  = "ICBC";     
	    
		String	custnam; //买家姓名
	    custnam = "张三 ";     
	    
	    String custmob;  //买家手机号
	    custmob = "13789888988"; 
	    
		String	custmail ; //买家邮箱
	    custmail  = "5783648743@qq.com";     
	    
	    String custcardno;  //买家身份证号
	    custcardno = "234453455666"; 
	    
	    String ThirdParty;//第三方支付平台
	    ThirdParty="LLP";
		String	Return_url ; //[必填]同步通知url、给用户的展示页面
	    Return_url  = "http://www.hrongpay.com/payResult.php"; 
	        
		String	Notify_url; //[必填]支付完成后，后台接收支付结果，可用来更新数据库值
	    Notify_url = "http://www.hrongpay.com/payResult.php";  
	    
	    String inMsg;  // [必填]MD5加密后的字符串
	    inMsg = "12D045CBB79ECDAE8A84D06466FC5586"; 

	    

	    //加密字符串  
	    String md5src = MerNo +"&"+ Signtype +"&"+ Prdordno +"&"+ Prdordnam +"&"+ Ordamt  +"&"+ Orddate +"&"+ TranType +"&"+ Paytype +"&"+ Notify_url+"&"+ MD5key;
	    System.out.println("加密前数据:"+md5src);
	    String md5srcUP = null;
		try {
			md5srcUP = TDMd5.MD5Sign(md5src);
		} catch (Exception e) {
			e.printStackTrace();
		}//MD5检验结果     
	    inMsg = md5srcUP.toUpperCase();
	    System.out.println("加密后数据:"+inMsg+"\r\n长度："+inMsg.length());
	}
}
