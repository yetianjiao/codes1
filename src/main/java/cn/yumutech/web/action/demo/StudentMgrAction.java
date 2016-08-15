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
import cn.yumutech.service.platform.SystemOptionService;
import cn.yumutech.util.BOConstants;
import cn.yumutech.util.WebConstants;
import cn.yumutech.vo.demo.Student;
import cn.yumutech.vo.platform.SystemOption;
import cn.yumutech.web.action.BaseAction;

/**
 * 用户管理Action
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class StudentMgrAction extends BaseAction {

	private static final long serialVersionUID = 5474278715367950587L;

	private static final Logger logger = Logger.getLogger(StudentMgrAction.class);

	@Resource
	private DemoService demoService;

	@Resource
	private SystemOptionService optionService;

	// when delete
	private Integer indx;

	private Student student = new Student();

	private List<Student> studentList;

	private List<SystemOption> genderList;

	/**
	 * 打开新增页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addIndex() throws Exception {

		try {

			genderList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_GENDER);

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

			setPagingAndSortStart(student);

			if (logger.isInfoEnabled()) {
				logger.info(student);
			}

			Map<String, Object> result = demoService.selectStudentList(student);

			setPagingAndSortEnd(result);

			studentList = (List<Student>) result.get(BOConstants.VALUE_LIST);
			genderList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_GENDER);

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
			student = demoService.selectStudentById(indx);

			genderList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_GENDER);
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

			student = demoService.selectStudentById(indx);

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
				logger.info(student);
			}

			demoService.insertStudent(student);
			
		} catch (DuplicateKeyException e) {
			List<String> strList = new ArrayList<String>();
			strList.add(getText(WebConstants.REMARK_TITLE));
			strList.add(String.valueOf(student.getSn()));
			addActionError(getText(WebConstants.UNIQUE_MESSAGE, strList));
			e.printStackTrace();
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		student = new Student();
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
				logger.info(student);
			}

			demoService.updateStudent(student);
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		student = new Student();
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

			demoService.deleteStudent(indx);
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		student = new Student();
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
	 * @param indx the indx to set
	 */
	public void setIndx(Integer indx) {
		this.indx = indx;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the studentList
	 */
	public List<Student> getStudentList() {
		return studentList;
	}

	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	/**
	 * @return the genderList
	 */
	public List<SystemOption> getGenderList() {
		return genderList;
	}

	/**
	 * @param genderList the genderList to set
	 */
	public void setGenderList(List<SystemOption> genderList) {
		this.genderList = genderList;
	}
	
	
	

}
