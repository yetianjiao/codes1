package cn.yumutech.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import cn.yumutech.vo.MobileError;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/**
 * XML工具类
 * 
 * @author zhaowei
 * 
 */
public class JsonUtil implements Serializable {

	private static final long serialVersionUID = 3020109307499276962L;

	private static final Logger logger = Logger.getLogger(JsonUtil.class);

	private static final String PARAM_REQ = "req";

	static {

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonValueProcessor() {

					@Override
					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {
						if (value instanceof Date) {
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd");
							return sdf.format((Date) value);
						}
						return value;
					}

					@Override
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {

						return value;
					}
				});

	}

	/**
	 * 获得json的输出流
	 * 
	 * @return
	 * @throws IOException
	 */
	public PrintWriter getResponseJsonPrintWriter() throws IOException {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=utf-8");
		// response.setContentType("application/x-www-form-urlencoded");
		PrintWriter out = response.getWriter();

		return out;
	}

	/**
	 * 获得请求的json消息内容
	 * 
	 * @return
	 */
	public String getRequestData() {
		String jsonData = ServletActionContext.getRequest().getParameter(
				PARAM_REQ);
		if (logger.isInfoEnabled()) {
			logger.info(jsonData);
		}
		return jsonData;

	}

	public String generateErrorData(String code, String string) {
		MobileError error = new MobileError();
		error.setCode(code);
		error.setString(string);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("error", error);
		map.put("data", "");
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
	}

	/***
	 * 返回json串
	 * 
	 * @param json
	 *            json参数
	 * @throws IOException
	 */
	public void outJsonString(String json) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma", "no-cache");
		response.setDateHeader("expires", 0L);
		response.getWriter().write(json);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public static void main(String[] args) throws Exception {
		JsonUtil util = new JsonUtil();
		util.generateErrorData("1", "xxxxxxxxx");

	}

}
