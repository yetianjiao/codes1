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

package cn.yumutech.vo;

import java.io.Serializable;

/**
 * 手机端错误vo
 * 
 * @author zhaowei
 * 
 */
public class MobileError implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -8523383781402916384L;

	private String code = "";

	private String string = "";

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	/**
	 * @param string
	 *            the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}

}
