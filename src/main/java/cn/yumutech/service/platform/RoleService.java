package cn.yumutech.service.platform;

import java.util.List;
import java.util.Map;

import cn.yumutech.vo.platform.Role;

/**
 * 角色管理Service接口
 * 
 * @author zhaowei
 * 
 */
public interface RoleService {

    /**
     * 查询角色
     * 
     * @param role
     * @return
     * @throws Exception
     */
    Map<String, Object> selectRoleList(Role role) throws Exception;

    /**
     * 获得所有的角色
     * 
     * @return
     */
    List<Role> getAllRole() throws Exception;

    /***
     * 根据角色ID来查询所有的角色
     * 
     * @param role_id
     * @return
     */
    List<Role> selectRoleListForId(int role_id);

}
