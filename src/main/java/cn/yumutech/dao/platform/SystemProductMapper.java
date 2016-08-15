package cn.yumutech.dao.platform;

import java.util.List;

import cn.yumutech.vo.platform.SystemProduct;

/**
 * 系统产品mapper
 * 
 * @author zhaowei
 * 
 */
public interface SystemProductMapper {

    /**
     * 获得所有的产品配置信息
     * 
     * @return
     */
    List<SystemProduct> getAllSystemProduct();

    /***
     * 根据产品code来查询对应的产品配置信息
     * 
     * @param code
     * @return
     */
    SystemProduct selectSystemProductByCode(String code);

}
