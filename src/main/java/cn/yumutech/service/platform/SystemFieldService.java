package cn.yumutech.service.platform;

import java.util.List;
import java.util.Map;

import cn.yumutech.vo.platform.SystemField;

/**
 * 系统分类Service接口
 * 
 * @author zhaowei
 * 
 */
public interface SystemFieldService {

    /**
     * 根据系统产品code获得系统分类信息
     * 
     * @param system_product_code
     * @return
     */
    List<SystemField> selectSystemFieldByProductCode(String system_product_code) throws Exception;

    /***
     * 查询所有的系统分类信息的id,name
     * 
     * @return
     */
    List<SystemField> selectSystemFieldAll() throws Exception;

    /**
     * 根据系统产品code获得系统分类信息
     * 
     * @param system_product_code
     * @return
     */
    Map<String, Object> selectSystemFieldByProductCodeList(String system_product_code) throws Exception;

}
