package cn.yumutech.web.action.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;

import cn.yumutech.service.demo.DemoService;
import cn.yumutech.util.BOConstants;
import cn.yumutech.util.WebConstants;
import cn.yumutech.vo.demo.Demo;
import cn.yumutech.vo.demo.Student;
import cn.yumutech.web.action.BaseAction;

/**
 * 用户管理Action
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class DemoMgrAction extends BaseAction {



	/**
	 * 
	 */
	private static final long serialVersionUID = -748227389201662378L;

	private static final Logger logger = Logger.getLogger(DemoMgrAction.class);

	@Resource
	private DemoService demoService;

	// when delete
	private Integer indx;

	private Demo demo = new Demo();

	private List<Student> demoList;

	/**
	 * 打开新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addIndex() throws Exception {

		try {

		} catch (Exception e) {
			logger.error("Exception Stack Info: ", e);
			throw e;
		}

		return SUCCESS;
	}

	/**
	 * 查询用户
	 */
	@SuppressWarnings("unchecked")
	public String search() throws Exception {

		try {

			setPagingAndSortStart(demo);

			if (logger.isInfoEnabled()) {
				logger.info(demo);
			}

			Map<String, Object> result = demoService.selectDemoList(demo);

			setPagingAndSortEnd(result);

			demoList = (List<Student>) result.get(BOConstants.VALUE_LIST);

		} catch (Exception e) {
			logger.error("Exception Stack Info: ", e);
			throw e;
		}

		return SUCCESS;
	}

	/**
	 * 打开编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editIndex() throws Exception {

		try {
			demo = demoService.selectDemoById(indx);

		} catch (Exception e) {
			logger.error("Exception Stack Info: ", e);
			throw e;
		}

		return SUCCESS;
	}

	/**
	 * 显示详情信息
	 * 
	 */
	public String detail() throws Exception {

		try {

			demo = demoService.selectDemoById(indx);

		} catch (Exception e) {
			logger.error("Exception Stack Info: ", e);
			throw e;
		}
		return SUCCESS;
	}

	/**
	 * 新增用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		try {

			if (logger.isInfoEnabled()) {
				logger.info(demo);
			}

			demoService.insertDemo(demo);
		} catch (DuplicateKeyException e) {
			List<String> strList = new ArrayList<String>();
			strList.add(getText(WebConstants.REMARK_TITLE));
			strList.add(String.valueOf(demo.getName()));
			addActionError(getText(WebConstants.UNIQUE_MESSAGE, strList));
			e.printStackTrace();
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		demo = new Demo();
		setPageNumber(1);
		search();
		return SUCCESS;
	}

	/**
	 * 编辑用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {

		try {

			if (logger.isInfoEnabled()) {
				logger.info(demo);
			}

			demoService.updateDemo(demo);
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		demo = new Demo();
		setPageNumber(1);
		search();
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {

		try {

			if (logger.isInfoEnabled()) {
				logger.info(indx);
			}

			demoService.deleteDemo(indx);
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		demo = new Demo();
		setPageNumber(1);
		search();
		return SUCCESS;
	}

	/**
	 * @return the indx
	 */
	public Integer getIndx() {
		return indx;
	}

	/**
	 * @param indx
	 *            the indx to set
	 */
	public void setIndx(Integer indx) {
		this.indx = indx;
	}

	/**
	 * @return the demo
	 */
	public Demo getDemo() {
		return demo;
	}

	/**
	 * @param demo
	 *            the demo to set
	 */
	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	/**
	 * @return the demoList
	 */
	public List<Student> getDemoList() {
		return demoList;
	}

	/**
	 * @param demoList
	 *            the demoList to set
	 */
	public void setDemoList(List<Student> demoList) {
		this.demoList = demoList;
	}

}
