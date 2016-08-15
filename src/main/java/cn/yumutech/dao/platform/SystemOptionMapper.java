/**
 * 
 */
package cn.yumutech.dao.platform;

import java.util.List;

import cn.yumutech.vo.platform.SystemOption;

import org.apache.ibatis.annotations.Param;

/**
 * 系统选项mapper
 * 
 * @author zhaowei
 * 
 */
public interface SystemOptionMapper {

    /**
     * 根据系统分类id获得项目
     * 
     * @param system_field_id
     * @return
     */
    List<SystemOption> selectSystemOptionByFieldID(int system_field_id);

    /***
     * 根据系统分类id获得项目记录数
     * 
     * @param system_field_id
     * @return
     */
    int selectSystemOptionByFieldIDCount(int system_field_id);

    /**
     * 插入项目
     * 
     * @param systemOption
     * @return
     */
    int insertSystemOption(SystemOption systemOption);

    /**
     * 更新项目
     * 
     * @param systemOption
     * @return
     */
    int updateSystemOption(SystemOption systemOption);

    /**
     * 删除项目
     * 
     * @param id
     * @return
     */
    int deleteSystemOption(int id);

    /**
     * 根据产品code和分类code获得项目
     * 
     * @param system_product_code
     * @param system_field_code
     * @return
     */
    List<SystemOption> selectSystemOption(@Param("system_product_code") String system_product_code, @Param("system_field_code") String system_field_code);

    /***
     * 根据Id查询项目信息
     * 
     * @param id
     * @return
     */
    SystemOption selectSystemOptionForId(int id);

}
