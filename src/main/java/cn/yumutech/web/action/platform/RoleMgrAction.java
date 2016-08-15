package cn.yumutech.web.action.platform;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.yumutech.service.platform.RoleService;
import cn.yumutech.util.BOConstants;
import cn.yumutech.vo.platform.Role;
import cn.yumutech.web.action.BaseAction;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 角色管理Action
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class RoleMgrAction extends BaseAction {

    private static final long serialVersionUID = 5474278715367950584L;

    private static final Logger logger = Logger.getLogger(RoleMgrAction.class);

    @Resource
    private RoleService roleService;

    private Role role = new Role();

    private List<Role> roleList;

    /**
     * 查询角色
     * 
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public String search() throws Exception {

        try {

            setPagingAndSortStart(role);

            if (logger.isInfoEnabled()) {
                logger.info(role);
            }

            Map<String, Object> result = roleService.selectRoleList(role);

            setPagingAndSortEnd(result);

            roleList = (List<Role>) result.get(BOConstants.VALUE_LIST);

        } catch (Exception e) {
            logger.error("Exception Stack Info: ", e);
            throw e;
        }
        return SUCCESS;
    }

    /**
     * @return the roleList
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * @param roleList
     *            the roleList to set
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

}
