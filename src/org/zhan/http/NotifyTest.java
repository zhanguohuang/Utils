package org.zhan.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author zhanguohuang
 * 
 */
public class NotifyTest {
	public static void main(String[] args) {
	       DefaultHttpClient httpClient = null;
			try {
				httpClient = new SSLClient();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        HttpPost postMethod = new HttpPost("http://localhost:9283/payment-gate-web/gateway/api/getMicroNotifyReq");
	        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
	        nvps.add(new BasicNameValuePair("productId", "productId"));
	        nvps.add(new BasicNameValuePair("transId", "transId"));
	        nvps.add(new BasicNameValuePair("merNo", "850440058121014"));
	        nvps.add(new BasicNameValuePair("orderNo", "100000011142"));
	        nvps.add(new BasicNameValuePair("transAmt", "transAmt"));
	        nvps.add(new BasicNameValuePair("orderDate", "orderDate"));
	        nvps.add(new BasicNameValuePair("respCode", "0000"));
	        nvps.add(new BasicNameValuePair("respDesc", "交易成功"));				
	        nvps.add(new BasicNameValuePair("acctNo", "acctNo"));					//持卡人信息
	        nvps.add(new BasicNameValuePair("Token", "Token"));
	        nvps.add(new BasicNameValuePair("signature", "signature"));
	        try {
	            postMethod.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
	            HttpResponse resp = httpClient.execute(postMethod);
	            String str = EntityUtils.toString(resp.getEntity(), "UTF-8");
	            System.out.println("返回的内容为:" + str);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	}
}
