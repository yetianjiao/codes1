/**
 * 
 *Title: 智慧农业平台 
 *Description: 智慧农业平台 
 *
 *Copyright: Copyright (c) 2014 成都信息工程学院移动应用与服务实验室 
 *Company:成都小果科技有限公司 
 * 
 * @author 移动应用与服务实验室 6502技术团队
 * @version 1.0 
 * 
 */

package cn.yumutech.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import cn.yumutech.util.JsonUtil;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Action手机端基类
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class BaseMobileAction extends BaseAction {

	private static final Logger logger = Logger
			.getLogger(BaseMobileAction.class);

	/**
     * 
     */
	private static final long serialVersionUID = -1758043785176386032L;

	public JsonUtil jsonUtil = new JsonUtil();

	/**
	 * 获得会话id
	 * 
	 * @return
	 */
	public String getSessionId() {
		HttpSession session = ServletActionContext.getRequest()
				.getSession(true);
		return session.getId();
	}

	/**
	 * 判断会话是否有效
	 * 
	 * @param sessionId
	 * @return
	 */
	public boolean sessionTimeout(String sessionId) {
		if (sessionId == null) {
			return true;
		} else if (!sessionId.equals(getSessionId())) {
			return true;

		}
		return false;

	}

	/**
	 * 返回会话过期数据
	 * 
	 * @param jsonUtil
	 */
	public void responseClientSessionTimeout() {
		PrintWriter out = null;
		String responseJsonData = "";
		try {
			responseJsonData = jsonUtil.generateErrorData("-99", "会话过期");
			out = jsonUtil.getResponseJsonPrintWriter();
			out.write(responseJsonData);
		} catch (IOException e) {
			logger.error("can not get the printwriter stream。 response json data:"
					+ responseJsonData);
		}

	}

	public void responseClientSystemException() {
		PrintWriter out = null;
		String responseJsonData = "";
		try {
			responseJsonData = jsonUtil.generateErrorData("-9", "系统异常");
			out = jsonUtil.getResponseJsonPrintWriter();
			out.write(responseJsonData);
		} catch (IOException e) {
			logger.error("can not get the printwriter stream。 response json data:"
					+ responseJsonData);
		}

	}

	/**
	 * 返回手机客户端数据
	 * 
	 * @param jsonUtil
	 * @param responseJsonData
	 */
	public void responseClient(String responseJsonData) {
		PrintWriter out = null;
		try {
			out = jsonUtil.getResponseJsonPrintWriter();
			out.write(responseJsonData);
		} catch (IOException e) {
			logger.error("can not get the printwriter stream。 response json data:"
					+ responseJsonData);
		}

	}

}
