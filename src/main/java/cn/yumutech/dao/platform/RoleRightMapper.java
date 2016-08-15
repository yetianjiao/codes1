package cn.yumutech.dao.platform;

import java.util.List;

import cn.yumutech.vo.platform.RightTemplate;
import cn.yumutech.vo.platform.RoleRight;

/**
 * 用户mapper
 * 
 * @author zhaowei
 * 
 */
public interface RoleRightMapper {

    List<RightTemplate> selectRoleRightList(Integer role_id);
    
 
    int insertRoleRight(RoleRight roleRight);
    
    int deleteRoleRightByRoleId(int role_id);
    
    
    List<RightTemplate> selectUserRightForCommon(Integer user_id);
    List<RightTemplate> selectUserRightForAdmin();
    
    int insertRoleRightBatch(RoleRight roleRight) ;

}
