package cn.yumutech.service.platform;

import java.util.List;

import cn.yumutech.vo.platform.SystemProduct;

/**
 * 系统产品Service接口
 * 
 * @author zhaowei
 * 
 */
public interface SystemProductService {

    /**
     * 获得所有的产品配置信息
     * 
     * @return
     */
    List<SystemProduct> getAllSystemProduct() throws Exception;

    /***
     * 根据产品code来查询对应的产品配置信息
     * 
     * @param code
     * @return
     */
    SystemProduct selectSystemProductByCode(String code) throws Exception;

}
