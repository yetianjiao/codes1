package cn.yumutech.util;

public class GetUrl {
	public static String getUrlById() throws Exception {
		// 获得登录用户的IP地址
		String ip = GetClientIp.getClientAddr();
		String url = Constants.URL1+ip;
		return url;
	}

	public static String getUrlByLongitudeAndLatitude(Double latitude,
			Double longitude) {
		String url = Constants.URL2 + latitude + "," + longitude;
		return url;
	}
}
