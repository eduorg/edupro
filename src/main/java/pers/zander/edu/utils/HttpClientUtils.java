package pers.zander.edu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;


/**
 * http请求工具类
 * @author 赵召
 * Dec 23, 2015 10:17:39 AM
 */
public class HttpClientUtils {

	public static HttpClientUtils httpClientUtils ;
	
	public static HttpClientUtils getInstance(){
		if(httpClientUtils==null){
			httpClientUtils = new HttpClientUtils();
		}
		return httpClientUtils ;
	}
	
	public String getStrResponseBodyAsStream(String url,int ctimeout,int stimeout,String charset){
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);  
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(30000);  
		HttpMethod httpGet = new GetMethod(url);
		StringBuffer result= new StringBuffer("");
		try {
			httpClient.executeMethod(httpGet);
			InputStream is = httpGet.getResponseBodyAsStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,charset));
			
			String s ;
			while((s=reader.readLine())!=null){
				result.append(s);
			} 
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
}
