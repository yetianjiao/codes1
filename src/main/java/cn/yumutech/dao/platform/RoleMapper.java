package cn.yumutech.dao.platform;

import java.util.List;

import cn.yumutech.vo.platform.Role;

/**
 * 角色mapper
 * 
 * @author zhaowei
 * 
 */
public interface RoleMapper {

    /**
     * 获得角色列表
     * 
     * @param role
     * @return
     */
    List<Role> selectRoleList(Role role);

    /**
     * 获得角色列表数
     * 
     * @param role
     * @return
     */
    int selectRoleListCount(Role role);

    /**
     * 获得所有的角色
     * 
     * @return
     */
    List<Role> getAllRole();

    /***
     * 根据角色ID来查询所有的角色
     * 
     * @param role_id
     * @return
     */
    List<Role> selectRoleListForId(int role_id);

}
