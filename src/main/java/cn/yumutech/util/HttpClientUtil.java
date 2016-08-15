package cn.yumutech.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 利用httpClient访问URL
 * 
 * @author lenovo
 *
 */
public class HttpClientUtil {
	public static String post(String url) throws Exception {

		HttpClient httpClient = new HttpClient(); // 获得HttpClient对象

		PostMethod method = new PostMethod(url); // 获得方法对象

		// 设置编码
		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");

		// 设置cookie
		method.getParams().setParameter("http.protocol.cookie-policy",
				CookiePolicy.BROWSER_COMPATIBILITY);

		httpClient.executeMethod(method);// 执行方法

		String respResult = method.getResponseBodyAsString();//获得结果

		method.releaseConnection();       //释放资源

		return respResult;                 //返回结果
	}

	public static void main(String[] args) throws Exception {
//		String url = "http://api.map.baidu.com/location/ip?ak=uaPxnOC20I9cuspge6f5t06n";
//		HttpClientUtil hcu = new HttpClientUtil();
//		String respResult = hcu.post(url);
//		System.out.println(respResult);

	}

}
