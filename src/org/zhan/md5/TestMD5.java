package org.zhan.md5;

public class TestMD5 {
	public static void main(String args[]){
		String MD5key; //[����]MD5keyֵΪ�����¸�֧��ע������á���Ҫ����ҵ����Ա��ȡ
	    MD5key = "9fKfnmt9zga1";

	    String MerNo;   //[����]�̻�IDΪ�����¸�֧��ע���������Ҫ����ҵ����Ա��ȡ
	    MerNo = "00000000000078";
	     
		String	Signtype; // [����]���ܷ�ʽ ĿǰֻΪM
	    Signtype = "M"; 
			
		String Prdordno;  // [����]������� 
	    Prdordno = "P201525432526395";

		String	bizType; //[����]�̻�ҵ������Ϊ�����¸�֧��ע��ʱ���趨
	    bizType = "10"; 
			
		String	Prdordnam; //[����]��Ʒ����
	    Prdordnam = "testproduct"; 
	    
	    String Ordamt;  // [����]֧�����Է�Ϊ��λ��
	    Ordamt = "121"; 
	    
		String	Orddate; // [����]�µ����ڽ���ʱ�䣺YYYYMMDD
	    Orddate = "20151105"; 
			
		String	TranType; //[����]��������
	    TranType = "20102";     
	    
	    String Paytype;  //[����]֧����ʽ
	    Paytype = "01"; 
	    
		String	bankCode ; // [����]���б���
	    bankCode  = "ICBC";     
	    
		String	custnam; //�������
	    custnam = "���� ";     
	    
	    String custmob;  //����ֻ���
	    custmob = "13789888988"; 
	    
		String	custmail ; //�������
	    custmail  = "5783648743@qq.com";     
	    
	    String custcardno;  //������֤��
	    custcardno = "234453455666"; 
	    
	    String ThirdParty;//������֧��ƽ̨
	    ThirdParty="LLP";
		String	Return_url ; //[����]ͬ��֪ͨurl�����û���չʾҳ��
	    Return_url  = "http://www.hrongpay.com/payResult.php"; 
	        
		String	Notify_url; //[����]֧����ɺ󣬺�̨����֧��������������������ݿ�ֵ
	    Notify_url = "http://www.hrongpay.com/payResult.php";  
	    
	    String inMsg;  // [����]MD5���ܺ���ַ���
	    inMsg = "12D045CBB79ECDAE8A84D06466FC5586"; 

	    

	    //�����ַ���  
	    String md5src = MerNo +"&"+ Signtype +"&"+ Prdordno +"&"+ Prdordnam +"&"+ Ordamt  +"&"+ Orddate +"&"+ TranType +"&"+ Paytype +"&"+ Notify_url+"&"+ MD5key;
	    System.out.println("����ǰ����:"+md5src);
	    String md5srcUP = null;
		try {
			md5srcUP = TDMd5.MD5Sign(md5src);
		} catch (Exception e) {
			e.printStackTrace();
		}//MD5������     
	    inMsg = md5srcUP.toUpperCase();
	    System.out.println("���ܺ�����:"+inMsg+"\r\n���ȣ�"+inMsg.length());
	}
}
