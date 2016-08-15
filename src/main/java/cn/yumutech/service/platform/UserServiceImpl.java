/**
 * 
 *Title: 智慧农业平台 
 *Description: 智慧农业平台 
 *
 *Copyright: Copyright (c) 2014 成都信息工程学院移动应用与服务实验室 
 *Company:成都小果科技有限公司 
 * 
 * @author 移动应用与服务实验室 6502技术团队
 * @version 1.0 
 * 
 */

package cn.yumutech.service.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.yumutech.dao.platform.RoleRightMapper;
import cn.yumutech.dao.platform.UserMapper;
import cn.yumutech.exception.UserNotEnabledException;
import cn.yumutech.exception.UserNotExistException;
import cn.yumutech.util.BOConstants;
import cn.yumutech.util.EncryptUtils;
import cn.yumutech.vo.platform.RightTemplate;
import cn.yumutech.vo.platform.RoleRight;
import cn.yumutech.vo.platform.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户管理Service实现类
 * 
 * @author zhaowei
 * 
 */
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("unused")
    private static final String ADMIN = "admin";

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;
    
    @Resource
    private RoleRightMapper roleRightMapper;

    @Override
    public Map<String, Object> selectUserList(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(user);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result.put(BOConstants.ROW_COUNT, userMapper.selectUserListCount(user));
            result.put(BOConstants.VALUE_LIST, userMapper.selectUserList(user));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    @Override
    @Transactional
    public int insertUser(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(user);
        }
        int result = 0;
        try {
            result = userMapper.insertUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    @Override
    @Transactional
    public int updateUser(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(user);
        }
        int result = 0;
        try {
            result = userMapper.updateUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    @Transactional
    public int deleteUser(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(user);
        }
        int result = 0;
        try {
            result = userMapper.deleteUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    @Override
    @Transactional
    public User login(User user) throws Exception {
        if (user == null) {
            logger.error("user is null");
            return null;
        }
        if (logger.isInfoEnabled()) {
            logger.info(" login user:" + user);
        }
        // 对密码加密
        String user_password = user.getPassword();
        user_password = EncryptUtils.getSHA1EncString(user_password);
        user.setPassword(user_password);

        String user_name = user.getUsername();
        int userExist = userMapper.isUserExist(user_name);
        int userEnabled = userMapper.isUserEnabled(user_name);
        if (userExist <= 0) {
            // user already existed
            logger.info("UserNotExistException");
            throw new UserNotExistException();
        }
        if (userEnabled <= 0) {
            // user not enabled
            logger.info("UserNotEnabledException");
            throw new UserNotEnabledException();
        }

        try {
            return userMapper.login(user);
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }

    @Override
    @Transactional
    public User checkPassword(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(" checkPassword:");
        }
        if (user == null)
            return null;
        // 对密码加密
        String user_password = user.getPassword();
        user_password = EncryptUtils.getSHA1EncString(user_password);
        user.setPassword(user_password);
        try {
            return userMapper.login(user);
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }

    @Override
    @Transactional
    public int updatePwd(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(" updatePwd user:" + user);
        }
        String newPassword = user.getPassword_new();
        user.setPassword_new(EncryptUtils.getSHA1EncString(newPassword));
        try {
            return userMapper.updatePwd(user);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean checkUserIsEnabled(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(" checkUserIsEnabled user:" + user);
        }
        String user_name = user.getUsername();
        int userEnabled = userMapper.isUserEnabled(user_name);
        return !(userEnabled <= 0);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.wasp.service.platform.UserService#selectAllUser()
     */
    @Override
    public List<User> selectAllUser() throws Exception {
        List<User> result = new ArrayList<User>();
        try {
            result = userMapper.getAllUser();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    @Override
    public User selectUserById(Integer id) throws Exception {
        User result = new User();
        try {
            result = userMapper.selectUserById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    @Override
    @Transactional
    public int updateUserPersonalInfo(User user) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(user);
        }
        int result = 0;
        try {
            result = userMapper.updateUserPersonalInfo(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    @Transactional
    public int resetPwd(User user) throws Exception {

        if (logger.isInfoEnabled()) {
            logger.info(user);
        }
        int result = 0;
        try {
            result = userMapper.resetPwd(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public Long selectUserIDByUserName(String username) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(username);
        }
        long result = 0;
        try {
            result = userMapper.selectUserIDByUserName(username);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public int isUserExist(String user_name) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(user_name);
        }
        int result = 0;
        try {
            result = userMapper.isUserExist(user_name);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.xiaoguo.psp.cms.service.platform.UserService#selectUserByType(java.lang.String)
     */
    @Override
    public List<User> selectUserByType(String type) throws Exception {
        List<User> result = new ArrayList<User>();
        try {
            result = userMapper.selectUserByType(type);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.xiaoguo.psp.cms.service.platform.UserService#selectRoleRightList(java.lang.Integer)
     */
    @Override
    public List<RightTemplate> selectRoleRightList(Integer role_id) throws Exception {
        List<RightTemplate> result = new ArrayList<RightTemplate>();
        try {
            result = roleRightMapper.selectRoleRightList(role_id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.xiaoguo.psp.cms.service.platform.UserService#insertRoleRight(com.xiaoguo.psp.cms.vo.base.RoleRight)
     */
    @Override
    public int insertRoleRight(RoleRight roleRight) throws Exception {
        int result = 0;
        try {
            result = roleRightMapper.insertRoleRight(roleRight);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.xiaoguo.psp.cms.service.platform.UserService#deleteRoleRightByRoleId(int)
     */
    @Override
    public int deleteRoleRightByRoleId(int role_id) throws Exception {
        int result = 0;
        try {
            result = roleRightMapper.deleteRoleRightByRoleId(role_id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.xiaoguo.psp.cms.service.platform.UserService#selectUserRightForCommon(java.lang.Integer)
     */
    @Override
    public List<RightTemplate> selectUserRightForCommon(Integer user_id) throws Exception {
        List<RightTemplate> result = new ArrayList<RightTemplate>();
        try {
            result = roleRightMapper.selectUserRightForCommon(user_id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.xiaoguo.psp.cms.service.platform.UserService#selectUserRightForAdmin()
     */
    @Override
    public List<RightTemplate> selectUserRightForAdmin() throws Exception {
        List<RightTemplate> result = new ArrayList<RightTemplate>();
        try {
            result = roleRightMapper.selectUserRightForAdmin();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.xiaoguo.psp.cms.service.platform.UserService#insertRoleRightBatch(com.xiaoguo.psp.cms.vo.base.RoleRight)
     */
    @Override
    public int insertRoleRightBatch(RoleRight roleRight) throws Exception {
        int result = 0;
        try {
            result = roleRightMapper.insertRoleRightBatch(roleRight);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }
    
    
}
