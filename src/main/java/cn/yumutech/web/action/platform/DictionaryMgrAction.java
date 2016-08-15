package cn.yumutech.web.action.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.yumutech.service.platform.SystemFieldService;
import cn.yumutech.service.platform.SystemOptionService;
import cn.yumutech.service.platform.SystemProductService;
import cn.yumutech.util.BOConstants;
import cn.yumutech.util.JsonUtil;
import cn.yumutech.vo.platform.SystemField;
import cn.yumutech.vo.platform.SystemOption;
import cn.yumutech.vo.platform.SystemProduct;
import cn.yumutech.web.action.BaseAction;
import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/***
 * 数据字典Action
 * 
 * @author tangjiale
 * 
 */
@Controller
@Scope("prototype")
public class DictionaryMgrAction extends BaseAction {

    private static final long serialVersionUID = -2968321217926542947L;

    private static final Logger logger = Logger.getLogger(DictionaryMgrAction.class);

    @Resource
    private SystemProductService systemProductService;

    @Resource
    private SystemFieldService systemFieldService;

    @Resource
    private SystemOptionService systemOptionService;

    private String product_code;
    private Integer field_id;
    private String field_name;
    private Integer indx;
    private Integer allow_edit;

    private SystemField systemField = new SystemField();
    private SystemOption systemOption = new SystemOption();

    private List<SystemField> fieldList;
    private List<SystemOption> optionList;

    /**
     * 打开新增页面
     * 
     * @return
     * @throws Exception
     */
    public String index() throws Exception {

        // fieldList=systemFieldService.selectSystemFieldAll();
        systemOption.setSystem_field_id(field_id);
        systemOption.setSystem_field_name(field_name);
        return SUCCESS;
    }

    /***
     * 数据字典列表
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String search() throws Exception {

        try {

            fieldList = new ArrayList<SystemField>();

            setPagingAndSortStart(systemField);
            Map<String, Object> result = systemFieldService.selectSystemFieldByProductCodeList(product_code);
            fieldList = (List<SystemField>) result.get(BOConstants.VALUE_LIST);
            setPagingAndSortEnd(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return SUCCESS;
    }

    /***
     * 添加数据字典
     * 
     * @return
     * @throws Exception
     */
    public String add() throws Exception {

        try {

            if (logger.isInfoEnabled()) {
                logger.info(systemOption);
            }

            systemOptionService.insertSystemOption(systemOption);

        } catch (Exception e) {
            logger.error(e.getMessage());
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

            systemOption = systemOptionService.selectSystemOptionForId(indx);
            fieldList = systemFieldService.selectSystemFieldAll();
        } catch (Exception e) {
            logger.error("Exception Stack Info: ", e);
            throw e;
        }

        return SUCCESS;
    }

    /***
     * 修改
     * 
     * @return
     * @throws Exception
     */
    public String edit() throws Exception {

        try {

            if (logger.isInfoEnabled()) {
                logger.info(systemOption);
            }

            systemOptionService.updateSystemOption(systemOption);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return SUCCESS;
    }

    /***
     * 删除
     * 
     * @return
     * @throws Exception
     */
    public String delete() throws Exception {

        try {

            if (logger.isInfoEnabled()) {
                logger.info(indx);
            }

            systemOptionService.deleteSystemOption(indx);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return SUCCESS;
    }

    /***
     * 查询选项
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String optionSearch() throws Exception {

        try {
            setPagingAndSortStart(systemOption);

            if (logger.isInfoEnabled()) {
                logger.info(systemOption);
            }
            Map<String, Object> result = systemOptionService.selectSystemOptionByFieldIDList(field_id);
            optionList = (List<SystemOption>) result.get(BOConstants.VALUE_LIST);
            setPagingAndSortEnd(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return SUCCESS;
    }

    /***
     * 数据树形列表
     * 
     * @return
     */
    public void tree() throws Exception {

        try {
            List<SystemProduct> list = new ArrayList<SystemProduct>();
            List<Object> listmap = new ArrayList<Object>();
            Map<String, Object> map;
            list = systemProductService.getAllSystemProduct();

            List<SystemField> listfield = new ArrayList<SystemField>();
            Map<String, Object> fieldMap;

            // 产品树
            for (SystemProduct product : list) {
                map = new HashMap<String, Object>();
                map.put("name", product.getName());
                map.put("open", true);

                listfield = systemFieldService.selectSystemFieldByProductCode(product.getCode());
                if (listfield != null) {
                    List<Object> fildmapList = new ArrayList<Object>();
                    for (SystemField field : listfield) {
                        fieldMap = new HashMap<String, Object>();
                        fieldMap.put("name", field.getName());
                        fieldMap.put("click", "option(" + field.getId() + "," + field.getAllow_edit_option() + ",'" + field.getName() + "')");
                        fildmapList.add(fieldMap);
                    }
                    map.put("children", fildmapList);
                }
                map.put("click", "field('" + product.getCode() + "')");
                listmap.add(map);
            }

            JSONArray array = JSONArray.fromObject(listmap);
            JsonUtil jsonUtil = new JsonUtil();
            jsonUtil.outJsonString(array.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * @return the fieldList
     */
    public List<SystemField> getFieldList() {
        return fieldList;
    }

    /**
     * @param fieldList
     *            the fieldList to set
     */
    public void setFieldList(List<SystemField> fieldList) {
        this.fieldList = fieldList;
    }

    /**
     * @return the product_code
     */
    public String getProduct_code() {
        return product_code;
    }

    /**
     * @param product_code
     *            the product_code to set
     */
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    /**
     * @return the optionList
     */
    public List<SystemOption> getOptionList() {
        return optionList;
    }

    /**
     * @param optionList
     *            the optionList to set
     */
    public void setOptionList(List<SystemOption> optionList) {
        this.optionList = optionList;
    }

    /**
     * @return the field_id
     */
    public Integer getField_id() {
        return field_id;
    }

    /**
     * @param field_id
     *            the field_id to set
     */
    public void setField_id(Integer field_id) {
        this.field_id = field_id;
    }

    /**
     * @return the systemField
     */
    public SystemField getSystemField() {
        return systemField;
    }

    /**
     * @param systemField
     *            the systemField to set
     */
    public void setSystemField(SystemField systemField) {
        this.systemField = systemField;
    }

    /**
     * @return the systemOption
     */
    public SystemOption getSystemOption() {
        return systemOption;
    }

    /**
     * @param systemOption
     *            the systemOption to set
     */
    public void setSystemOption(SystemOption systemOption) {
        this.systemOption = systemOption;
    }

    /**
     * @return the field_name
     */
    public String getField_name() {
        return field_name;
    }

    /**
     * @param field_name
     *            the field_name to set
     */
    public void setField_name(String field_name) {
        this.field_name = field_name;
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
     * @return the allow_edit
     */
    public Integer getAllow_edit() {
        return allow_edit;
    }

    /**
     * @param allow_edit
     *            the allow_edit to set
     */
    public void setAllow_edit(Integer allow_edit) {
        this.allow_edit = allow_edit;
    }

}
