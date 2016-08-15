/**
 * 
 */
package cn.yumutech.dao.platform;

import java.util.List;

import cn.yumutech.vo.platform.SystemField;

/**
 * 系统分类mapper
 * 
 * @author zhaowei
 * 
 */
public interface SystemFieldMapper {

    /**
     * 根据系统产品code获得系统分类信息
     * 
     * @param system_product_code
     * @return
     */
    List<SystemField> selectSystemFieldByProductCode(String system_product_code);

    /***
     * 查询所有的系统分类信息的id,name
     * 
     * @return
     */
    List<SystemField> selectSystemFieldAll();

    /***
     * 根据产品code来查询记录条数
     * 
     * @param system_product_code
     * @return
     */
    int selectSystemFieldByProductCodeCount(String system_product_code);

}
