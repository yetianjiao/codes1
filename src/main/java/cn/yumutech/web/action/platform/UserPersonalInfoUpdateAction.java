package cn.yumutech.web.action.platform;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import cn.yumutech.service.platform.RoleService;
import cn.yumutech.service.platform.SystemOptionService;
import cn.yumutech.service.platform.UserService;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.yumutech.util.BOConstants;
import cn.yumutech.util.FileUtil;
import cn.yumutech.util.GetUtil;
import cn.yumutech.util.WebConstants;
import cn.yumutech.vo.platform.SystemOption;
import cn.yumutech.vo.platform.User;
import cn.yumutech.web.action.BaseAction;

/**
 * 个人信息管理Action
 * 
 * @author tangjiale
 * 
 */
@Controller
@Scope("prototype")
public class UserPersonalInfoUpdateAction extends BaseAction {

    private static final long serialVersionUID = 5474278715367950584L;

    private static final Logger logger = Logger.getLogger(UserPersonalInfoUpdateAction.class);

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private SystemOptionService optionService;


    // when delete
    private Integer indx;
    private String username;
    private String password = "";
    private String password_new = "";
    private String password_confirm = "";
    private User user = new User();

    private List<User> userList;
    private List<SystemOption> sexList;

    /***
     * 修改
     * 
     * @return
     * @throws Exception
     */
    public String updatePasswordIndex() throws Exception {

        try {
            password = "";
            password_new = "";
            password_confirm = "";

        } catch (Exception e) {
            logger.error("Exception Stack Info: ", e);
            throw e;
        }
        return SUCCESS;
    }

    /***
     * 修改密码
     * 
     * @return
     * @throws Exception
     */
    public String userPasswordUpdate() throws Exception {

        try {
            user = new User();
            user.setId(getSessionUserIndx());
            user.setUsername(getSessionUser().getUsername());
            user.setPassword(password);
            user.setPassword_new(password_new);

            if (logger.isInfoEnabled()) {
                logger.info(" updPassword user: " + user);
            }

            User loginUser = userService.checkPassword(user);
            if (loginUser == null) {
                addActionMessage("原始密码错误");
                password = "";
                password_new = "";
                password_confirm = "";
                return SUCCESS;
            }

            if (!userService.checkUserIsEnabled(user)) {
                addActionMessage("当前帐号不可用");
                return SUCCESS;

            }

            int updatePwd = userService.updatePwd(user);
            if (updatePwd > 0) {
                addActionMessage("密码修改成功");
                password = "";
                password_new = "";
                password_confirm = "";
                return SUCCESS;
            } else {
                addActionMessage("密码修改失败");
                return SUCCESS;
            }

        } catch (Exception ex) {
            addActionError("修改密码失败");
            logger.error("Exception Stack Info: ", ex);
            throw ex;
        }
    }

    /***
     * 修改用户信息数据绑定
     * 
     * @return
     * @throws Exception
     */
    public String updateInfoIndex() throws Exception {

        try {
            if (logger.isInfoEnabled()) {
                logger.info(getSessionUserIndx());
            }

            user = userService.selectUserById(getSessionUserIndx());
            sexList = optionService.selectSystemOption(BOConstants.SYSTEM_PRODUCT_GLOBAL, BOConstants.SYSTEM_FIELD_GENDER);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return SUCCESS;
    }

    /***
     * 修改用户自身信息
     * 
     * @return
     * @throws Exception
     */
    public String updateUserInfo() throws Exception {

        try {

            user.setId(getSessionUserIndx());

           
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

            int result = userService.updateUserPersonalInfo(user);
            if (result > 0) {
                addActionMessage("用户信息修改成功");
            } else {
                addActionMessage("用户信息修改失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return SUCCESS;

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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the password_new
     */
    public String getPassword_new() {
        return password_new;
    }

    /**
     * @param password_new
     *            the password_new to set
     */
    public void setPassword_new(String password_new) {
        this.password_new = password_new;
    }

    /**
     * @return the password_confirm
     */
    public String getPassword_confirm() {
        return password_confirm;
    }

    /**
     * @param password_confirm
     *            the password_confirm to set
     */
    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

}
