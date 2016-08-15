package cn.yumutech.web.action.platform;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.yumutech.service.platform.RoleService;
import cn.yumutech.service.platform.SystemOptionService;
import cn.yumutech.service.platform.UserService;
import cn.yumutech.util.BOConstants;
import cn.yumutech.util.Constants;
import cn.yumutech.util.EncryptUtils;
import cn.yumutech.util.FileUtil;
import cn.yumutech.util.GetUtil;
import cn.yumutech.util.JsonUtil;
import cn.yumutech.util.WebConstants;
import cn.yumutech.vo.platform.Role;
import cn.yumutech.vo.platform.SystemOption;
import cn.yumutech.vo.platform.User;
import cn.yumutech.web.action.BaseAction;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;

/**
 * 用户管理Action
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class UserMgrAction extends BaseAction {

    private static final long serialVersionUID = 5474278715367950584L;

    private static final Logger logger = Logger.getLogger(UserMgrAction.class);

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private SystemOptionService optionService;
    

    // when delete
    private Integer indx;
    private String username;
    private User user = new User();

    private List<User> userList;
    private List<Role> roleList;
    private List<SystemOption> sexList;
    private List<SystemOption> userStatusList;


    /**
     * 打开新增页面
     * 
     * @return
     * @throws Exception
     */
    public String index() throws Exception {

        try {

            roleList = roleService.getAllRole();
            
            Integer role_id=getSessionUser().getRole_id();
            if(role_id==2){
            	roleList.remove(0);
            	roleList.remove(0);
            }
 
            sexList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_GENDER);
            userStatusList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_USER_STATE);
        } catch (Exception e) {
            logger.error("Exception Stack Info: ", e);
            throw e;
        }

        return SUCCESS;
    }

    /**
     * 查询用户
     */
    @SuppressWarnings("unchecked")
    public String search() throws Exception {

        try {

            setPagingAndSortStart(user);

            if (logger.isInfoEnabled()) {
                logger.info(user);
            }

            Map<String, Object> result = userService.selectUserList(user);

            setPagingAndSortEnd(result);

            userList = (List<User>) result.get(BOConstants.VALUE_LIST);
            roleList = roleService.getAllRole();

        } catch (Exception e) {
            logger.error("Exception Stack Info: ", e);
            throw e;
        }

        return SUCCESS;
    }

    /**
     * 打开编辑页面
     * 
     * @return
     * @throws Exception
     */
    public String editIndex() throws Exception {

        try {
            user = userService.selectUserById(indx);
            roleList = roleService.getAllRole();
            Integer role_id=getSessionUser().getRole_id();
            if(role_id==2){
            	roleList.remove(0);
            	roleList.remove(0);
            }
            

            sexList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_GENDER);
            userStatusList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_USER_STATE);
        } catch (Exception e) {
            logger.error("Exception Stack Info: ", e);
            throw e;
        }

        return SUCCESS;
    }

    /**
     * 显示详情信息
     * 
     */
    public String detail() throws Exception {

        try {

            user = userService.selectUserById(indx);

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

            String password = EncryptUtils.getSHA1EncString(Constants.PASSWORD_INIT);
            user.setPassword(password);
            
            if (getFile() != null) {
                String realpath = ServletActionContext.getServletContext().getRealPath(getText(WebConstants.IMAGE_SAVE_BASE_DIR));
                String uuid = GetUtil.getUUID();
                String file_name = uuid + "." + FileUtil.getFileExtension(getFileFileName());
                File savefile = new File(new File(realpath), file_name);
                if (!savefile.getParentFile().exists()) {
                    savefile.getParentFile().mkdirs();
                }

                FileUtils.copyFile(getFile(), savefile);

                user.setLogo_path(getText(WebConstants.IMAGE_SAVE_BASE_DIR) + file_name);
            }

            if (logger.isInfoEnabled()) {
                logger.info(user);
            }

            userService.insertUser(user);
        } catch (DuplicateKeyException e) {
            List<String> strList = new ArrayList<String>();
            strList.add(getText(WebConstants.REMARK_TITLE));
            strList.add(String.valueOf(user.getUsername()));
            addActionError(getText(WebConstants.UNIQUE_MESSAGE, strList));
            e.printStackTrace();
        } catch (Exception ex) {
            logger.error("Exception Stack Info: ", ex);
            throw ex;
        }

        user = new User();
        setPageNumber(1);
        search();
        return SUCCESS;
    }

    /**
     * 编辑用户
     * 
     * @return
     * @throws Exception
     */
    public String edit() throws Exception {

        try {
            if (getFile() != null) {
                String realpath = ServletActionContext.getServletContext().getRealPath(getText(WebConstants.IMAGE_SAVE_BASE_DIR));
                String uuid = GetUtil.getUUID();
                String file_name = uuid + "." + FileUtil.getFileExtension(getFileFileName());
                File savefile = new File(new File(realpath), file_name);
                if (!savefile.getParentFile().exists()) {
                    savefile.getParentFile().mkdirs();
                }

                FileUtils.copyFile(getFile(), savefile);

                user.setLogo_path(getText(WebConstants.IMAGE_SAVE_BASE_DIR) + file_name);
            }
            

            if (logger.isInfoEnabled()) {
                logger.info(user);
            }
            

            userService.updateUser(user);
        } catch (DuplicateKeyException e) {
            List<String> strList = new ArrayList<String>();
            strList.add(getText(WebConstants.REMARK_TITLE));
            strList.add(String.valueOf(user.getUsername()));
            addActionError(getText(WebConstants.UNIQUE_MESSAGE, strList));
        } catch (Exception ex) {
            logger.error("Exception Stack Info: ", ex);
            throw ex;
        }

        user = new User();
        setPageNumber(1);
        search();
        return SUCCESS;
    }

    /**
     * 删除用户
     * 
     * @return
     * @throws Exception
     */
    public String delete() throws Exception {

        try {

            user = new User();
            user.setId(indx);

            if (logger.isInfoEnabled()) {
                logger.info(user);
            }

            userService.deleteUser(user);
        } catch (Exception ex) {
            logger.error("Exception Stack Info: ", ex);
            throw ex;
        }

        user = new User();
        setPageNumber(1);
        search();
        return SUCCESS;
    }

    /***
     * 重置密码
     * 
     * @return
     */
    public String reset() throws Exception {

        try {

            String password = EncryptUtils.getSHA1EncString(Constants.PASSWORD_INIT);
            user.setPassword_new(password);
            user.setUsername(username);

            if (logger.isInfoEnabled()) {
                logger.info(user);
            }

            userService.resetPwd(user);
            addActionMessage(username + "  密码重置成功");

        } catch (DuplicateKeyException e) {
            List<String> strList = new ArrayList<String>();
            strList.add(getText(WebConstants.REMARK_TITLE));
            strList.add(String.valueOf(user.getUsername()));
            addActionMessage(getText(WebConstants.UNIQUE_MESSAGE, strList));
            e.printStackTrace();
        } catch (Exception ex) {
            logger.error("Exception Stack Info: ", ex);
            throw ex;
        }

        user = new User();
        setPageNumber(1);
        search();
        return SUCCESS;

    }

    /***
     * 检查用户是否存在
     */
    public void isUserExist() throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(username);
        }
        String str = "";
        try {

            int result = userService.isUserExist(username);
            if (result > 0) {

                str = "[" + username + "," + true + "]";
            } else {
                str = "[" + username + "," + false + "]";
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.outJsonString(str);

    }

    /**
     * @return the indx
     */
    public Integer getIndx() {
        return indx;
    }

    /**
     * @param indx
     *            the indx to set
     */
    public void setIndx(Integer indx) {
        this.indx = indx;
    }

    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList
     *            the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
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
     * @return the sexList
     */
    public List<SystemOption> getSexList() {
        return sexList;
    }

    /**
     * @param sexList
     *            the sexList to set
     */
    public void setSexList(List<SystemOption> sexList) {
        this.sexList = sexList;
    }

    /**
     * @return the userStatusList
     */
    public List<SystemOption> getUserStatusList() {
        return userStatusList;
    }

    /**
     * @param userStatusList
     *            the userStatusList to set
     */
    public void setUserStatusList(List<SystemOption> userStatusList) {
        this.userStatusList = userStatusList;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    

}
