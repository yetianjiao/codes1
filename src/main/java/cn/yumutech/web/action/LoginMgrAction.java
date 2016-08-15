package cn.yumutech.web.action;

import javax.annotation.Resource;

import cn.yumutech.exception.UserNotEnabledException;
import cn.yumutech.exception.UserNotExistException;
import cn.yumutech.service.platform.UserService;
import cn.yumutech.util.Constants;
import cn.yumutech.util.ValidAlertConstants;
import cn.yumutech.vo.platform.User;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 登陆Action
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class LoginMgrAction extends BaseAction {

    private static final long serialVersionUID = 5701198348255353888L;

    private static final Logger logger = Logger.getLogger(LoginMgrAction.class);

    @Resource
    private UserService userService;

    // @Resource
    // private LogService logService;

    // @Resource
    // private RightSettingService rightSettingService;

    private User user;
    private String checkValid;

    /**
     * 导向login登录页面
     * 
     * @return
     */
    public String index() {
        checkValid = "";
        return SUCCESS;
    }

    /**
     * 登录
     * 
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(" login user: " + user);
        }

        if (user == null) {
            if (getSession() != null && getSession().get(Constants.SESSION_USER) != null) {
                return SUCCESS;
            }
            checkValid = getText(ValidAlertConstants.LOGIN_WARN);
            return INPUT;
        }
        String user_name = user.getUsername();
        if ("".equalsIgnoreCase(user_name) || "".equalsIgnoreCase(user.getPassword())) {
            checkValid = getText(ValidAlertConstants.LOGIN_WARN);
            return INPUT;
        }

        User loginUser = null;
        try {
            loginUser = userService.login(user);
        } catch (UserNotExistException e) {
            e.printStackTrace();
            logger.error("UserNotExistException", e);
            checkValid = getText(ValidAlertConstants.LOGIN_NO_SUCH_USER);
            return INPUT;
        } catch (UserNotEnabledException e) {
            logger.error("UserNotEnabledException", e);
            checkValid = getText(ValidAlertConstants.LOGIN_NOT_ENABLED);
            e.printStackTrace();
            return INPUT;
        }

        if (loginUser == null) {
            checkValid = getText(ValidAlertConstants.LOGIN_ERROR);
            return INPUT;
        }
        //
        // List<Module> userRights =
        // rightSettingService.getUserRights(user_name);
        // Map<String, Module> map = new HashMap<String, Module>();
        // if (userRights != null) {
        // for (Module module : userRights) {
        // map.put(module.getModule_code(), module);
        // }
        // getSession().put(SESSION_USER_RIGHT, map);
        // }
        if (loginUser != null) {
            getSession().put(SESSION_USER, loginUser);
            //
            // logService.loadLog(loginUser.getUser_id(), "PC端登录", "",
            // getclientIP());
        }
//        List<RightTemplate> userRights;
//        if(!"admin".equals(loginUser.getUsername())){
//            userRights = userService.selectUserRightForCommon(loginUser.getId());
//        }else{
//            userRights = userService.selectUserRightForAdmin();
//        }
//       
//        Map<String, RightTemplate> map = new HashMap<String, RightTemplate>();
//        if (userRights != null) {
//            for (RightTemplate rr : userRights) {
//                map.put(rr.getCode(), rr);
//            }
//            getSession().put(SESSION_USER_RIGHT, map);
//        }

        logger.debug(" user Action page search! sort by " + user.getOrderBy());
        return SUCCESS;
    }

    /**
     * 注销
     * 
     * @return
     */
    public String loginOut() throws Exception {

        if (logger.isInfoEnabled()) {
            logger.info(" loginOut  ,session clear ");
        }

        // Object obj = getSession().get(SESSION_USER);
        //
        // if (obj != null) {
        // logService.loadLog(((User) (obj)).getId(), "PC端注销退出", "",
        // getclientIP());
        // }

        getSession().clear();
        return SUCCESS;
    }

    /**
     * 重定向
     * 
     * @return
     */
    public String loginRedirect() {

        if (logger.isInfoEnabled()) {
            logger.info(" loginRedirect  ");
        }

        getSession().clear();
        return SUCCESS;
    }

    /**
     * 修改密码
     * 
     * @return
     * @throws Exception
     */
    public String updPassword() throws Exception {

        if (logger.isInfoEnabled()) {
            logger.info(" updPassword user: " + user);
        }

        User loginUser = userService.checkPassword(user);
        if (loginUser == null) {
            responseFail(ValidAlertConstants.LOGIN_WRONG_USER_PWD);
            return null;
        }

        if (!userService.checkUserIsEnabled(user)) {
            responseFail(ValidAlertConstants.LOGIN_NOT_ENABLED);
            return null;
        }

        int updatePwd = userService.updatePwd(user);
        if (updatePwd > 0) {
            checkValid = " update success...";
        }
        responseSuccess(ValidAlertConstants.LOGIN_UPD_PASSWORD_SUCCESS);
        return null;
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
     * @return the checkValid
     */
    public String getCheckValid() {
        return checkValid;
    }

    /**
     * @param checkValid
     *            the checkValid to set
     */
    public void setCheckValid(String checkValid) {
        this.checkValid = checkValid;
    }

}
