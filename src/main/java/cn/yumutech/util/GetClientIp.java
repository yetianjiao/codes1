package cn.yumutech.util;

import org.apache.struts2.ServletActionContext;

public class GetClientIp {
	public static String getClientAddr() {

		Object ip = ServletActionContext.getRequest().getHeader(
				"X-Forwarded-For".toLowerCase());
		if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
			ip = ServletActionContext.getRequest().getHeader(
					"Proxy-Client-IP".toLowerCase());
		}
		if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
			ip = ServletActionContext.getRequest().getHeader(
					"WL-Proxy-Client-IP".toLowerCase());
		}
		if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
			ip = ServletActionContext.getRequest().getHeader(
					"HTTP_CLIENT_IP".toLowerCase());
		}
		if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
			ip = ServletActionContext.getRequest().getHeader(
					"HTTP_X_FORWARDED_FOR".toLowerCase());
		}
		if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
			ip = ServletActionContext.getRequest().getRemoteAddr();
		}

		return ip == null ? "" : ip.toString();
	}
}
