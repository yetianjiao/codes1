package cn.yumutech.web.action.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;

import cn.yumutech.service.demo.EquipService;
import cn.yumutech.util.BOConstants;
import cn.yumutech.util.WebConstants;
import cn.yumutech.vo.demo.Equip;
import cn.yumutech.vo.demo.Student;
import cn.yumutech.web.action.BaseAction;

public class EquipMgrAction extends BaseAction {

	private static final long serialVersionUID = -4695581155422717842L;

	private static final Logger logger = Logger.getLogger(EquipMgrAction.class);
	
	private Equip equip = new Equip();
	
	private List<Equip> equipList;
	
	private Integer indx;
	
	//price 用于接收页面传来的string类型price，转换为double再传值给e_price
	private String price; 
	
	@Resource
	private EquipService equipServices;
	
	public List<Equip> getEquipList() {
		return equipList;
	}
	public void setEquipList(List<Equip> equipList) {
		this.equipList = equipList;
	}	
	public Equip getEquip() {
		return equip;
	}
	public void setEquip(Equip equip) {
		this.equip = equip;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getIndx() {
		return indx;
	}
	public void setIndx(Integer indx) {
		this.indx = indx;
	}
	/*
	 * 注意：
	 * 1、凡是涉及到页面之间穿点传递的参数均需要getset方法
	 * 2、Spring注解注释，service以及其中涉及到的具体方法的注解
	 */
	/**
	 * 查询用户再显示
	 */	
	@SuppressWarnings("unchecked")
	public String search() throws Exception {

		try {
			System.out.println("================action===================");
			setPagingAndSortStart(equip);

			if (logger.isInfoEnabled()) {
				logger.info(equip);
			}

			System.out.println("***************"+equip.toString());
			Map<String, Object> result = equipServices.selectEquipList(equip);

			setPagingAndSortEnd(result);

			setEquipList((List<Equip>) result.get(BOConstants.VALUE_LIST)); 
			System.out.println(result.get(BOConstants.VALUE_LIST));
			
		} catch (Exception e) {
			logger.error("Exception Stack Info: ", e);
			throw e;
		}

		return SUCCESS;
	}

/**
 * 添加设备
 * @return
 * @throws Exception
 */
	@SuppressWarnings("unchecked")
	public String addIndex() throws Exception {
		return SUCCESS;
	}
	
	public String add() throws Exception {
		try {

			if (logger.isInfoEnabled()) {
				logger.info(equip);
			}
			equip.setE_price(Double.parseDouble(price));
			System.out.println("~~~~~~~~~~~~~~~~~~~"+equip);
			equipServices.insertEquip(equip);
		} catch (DuplicateKeyException e) {
//			List<String> strList = new ArrayList<String>();
//			strList.add(getText(WebConstants.REMARK_TITLE));
//			strList.add(String.valueOf(student.getSn()));
//			addActionError(getText(WebConstants.UNIQUE_MESSAGE, strList));
			e.printStackTrace();
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		equip= new Equip();
		setPageNumber(1);
		search();
		return SUCCESS;
	}
	/**
	 * 先根据Id查找，再过渡跳转至编辑页面
	 * @return
	 * @throws Exception
	 */
	public String editIndex() throws Exception {

		try {
			System.out.println(indx);
			equip = equipServices.selectEquipById(indx);
			System.out.println("！！！！！！！！！！！！！！！！！！！！根据id得到的equip"+equip);
			setPrice(equip.getE_price().toString());
		} catch (Exception e) {
			logger.error("Exception Stack Info: ", e);
			throw e;
		}
		return SUCCESS;	
	}
	/**
	 * 编辑需要更改的设备
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {

		try {

			if (logger.isInfoEnabled()) {
				logger.info(equip);
			}
			equip.setE_price(Double.parseDouble(price));
			System.out.println("====================需要更改的equip"+ equip);
			equipServices.updateEquip(equip);
			
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		equip = new Equip();
		setPageNumber(1);
		search();
		return SUCCESS;
	}
	/**
	 * 
	 * 删除设备
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {

		try {

			if (logger.isInfoEnabled()) {
				logger.info(indx);
			}
			equipServices.deleteEquip(indx);
		} catch (Exception ex) {
			logger.error("Exception Stack Info: ", ex);
			throw ex;
		}

		equip = new Equip();
		setPageNumber(1);
		search();
		return SUCCESS;
	}
	
}
