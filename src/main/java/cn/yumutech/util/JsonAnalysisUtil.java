package cn.yumutech.util;

import net.sf.json.JSONObject;

/**
 * 
 * @author lenovo JSON数据的解析返回的IP定位的数据
 */
public class JsonAnalysisUtil {
	/**
	 * 根据IP地址查找地理位置解析json数据 --PC端
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	public static String analysisIpData(String jsonData) throws Exception {

		jsonData = new String(jsonData.getBytes(), "UTF-8");

		JSONObject jsonObject = JSONObject.fromObject(jsonData);
		JSONObject content = jsonObject.getJSONObject("content");
		JSONObject address_detail = content.getJSONObject("address_detail");

		String province = address_detail.getString("province");
		String city = address_detail.getString("city");
		String district = address_detail.getString("district");
		String street = address_detail.getString("street");
		String street_number = address_detail.getString("street_number");
		String address = province + city + district + street + street_number;
		return address;
	}

	/**
	 * 根据经度纬度查找地理位置解析json数据 --手机端
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	public static String analysisGeocodingDate(String jsonData)
			throws Exception {
		jsonData = new String(jsonData.getBytes(), "UTF-8");

		JSONObject jsonObject = JSONObject.fromObject(jsonData);
		JSONObject result = jsonObject.getJSONObject("result");
		String formatted_address = result.getString("formatted_address");
		return formatted_address;
	}

	public static void main(String[] args) throws Exception {
		// String jsonData =
		// "{'address':'CN|\u56db\u5ddd|\u6210\u90fd|None|CERNET|0|0','content':{'address_detail':{'province':'\u56db\u5ddd\u7701','city':'\u6210\u90fd\u5e02','district':'','street':'','street_number':'','city_code':75},'address':'\u56db\u5ddd\u7701\u6210\u90fd\u5e02','point':{'y':'3569251.03','x':'11584914.3'}},'status':0}";
		// String address = analysisIpData(jsonData);
		// System.out.println(address);

		Double longitude = 116.322987;
		Double latitude = 39.983424;
		String url = GetUrl.getUrlByLongitudeAndLatitude(latitude, longitude);
		String formatted_address = JsonAnalysisUtil
				.analysisGeocodingDate(HttpClientUtil.post(url));
		System.out.println(formatted_address);

	}
}
