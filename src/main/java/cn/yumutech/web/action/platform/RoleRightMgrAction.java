package cn.yumutech.web.action.platform;

import java.util.List;

import javax.annotation.Resource;

import cn.yumutech.service.platform.UserService;
import cn.yumutech.vo.platform.RightTemplate;
import cn.yumutech.vo.platform.RoleRight;
import cn.yumutech.web.action.BaseAction;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RoleRightMgrAction extends BaseAction {

    private static final long serialVersionUID = 5474278715367950584L;

    private static final Logger logger = Logger.getLogger(RoleRightMgrAction.class);

    @Resource
    private UserService userService;

    List<RightTemplate> roleRightList;

    private Integer role_id;
    
    private String role_name;
    
    private String [] codes;


    /**
     * 打开新增页面
     * 
     * @return
     * @throws Exception
     */
    public String index() throws Exception {

        try {

            roleRightList = userService.selectRoleRightList(role_id);

        } catch (Exception e) {
            logger.error("Exception Stack Info: ", e);
            throw e;
        }

        return SUCCESS;
    }

    /**
     * 新增用户
     * 
     * @return
     * @throws Exception
     */
    public String add() throws Exception {

        try {
            userService.deleteRoleRightByRoleId(role_id);
            
            if(codes!=null &&codes.length >0){
               
                for (int i = 0; i < codes.length; i++) {
                    RoleRight rr = new RoleRight();
                    rr.setRole_id(role_id);
                    rr.setRighttemplate_code(codes[i]);

                     userService.insertRoleRight(rr);
                }
              
            }
            
            


           
        } catch (Exception ex) {
            logger.error("Exception Stack Info: ", ex);
            throw ex;
        }

        index();
        return SUCCESS;
    }

    /**
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return the roleRightList
     */
    public List<RightTemplate> getRoleRightList() {
        return roleRightList;
    }

    /**
     * @param roleRightList the roleRightList to set
     */
    public void setRoleRightList(List<RightTemplate> roleRightList) {
        this.roleRightList = roleRightList;
    }

    /**
     * @return the role_id
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * @param role_id the role_id to set
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the logger
     */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * @return the role_name
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * @param role_name the role_name to set
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    /**
     * @return the codes
     */
    public String[] getCodes() {
        return codes;
    }

    /**
     * @param codes the codes to set
     */
    public void setCodes(String[] codes) {
        this.codes = codes;
    }
    
    

}
