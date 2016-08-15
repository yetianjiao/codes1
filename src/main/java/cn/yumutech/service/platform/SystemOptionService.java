package cn.yumutech.service.platform;

import java.util.List;
import java.util.Map;

import cn.yumutech.vo.platform.SystemOption;

/**
 * 系统选项Service接口
 * 
 * @author zhaowei
 * 
 */
public interface SystemOptionService {

    /**
     * 根据系统分类id获得项目
     * 
     * @param system_field_id
     * @return
     */
    List<SystemOption> selectSystemOptionByFieldID(int system_field_id) throws Exception;

    /***
     * 根据系统分类id获得项目
     * 
     * @param system_field_id
     * @return
     * @throws Exception
     */
    Map<String, Object> selectSystemOptionByFieldIDList(int system_field_id) throws Exception;

    /**
     * 插入项目
     * 
     * @param user
     * @return
     */
    int insertSystemOption(SystemOption systemOption) throws Exception;

    /**
     * 更新项目
     * 
     * @param User
     * @return
     */
    int updateSystemOption(SystemOption systemOption) throws Exception;

    /**
     * 删除项目
     * 
     * @param id
     * @return
     */
    int deleteSystemOption(int id) throws Exception;

    /**
     * 根据产品code和分类code获得项目
     * 
     * @param system_product_code
     * @param system_field_code
     * @return
     */
    List<SystemOption> selectSystemOption(String system_product_code, String system_field_code) throws Exception;

    /***
     * 根据Id查询项目信息
     * 
     * @param id
     * @return
     */
    SystemOption selectSystemOptionForId(int id) throws Exception;

}
