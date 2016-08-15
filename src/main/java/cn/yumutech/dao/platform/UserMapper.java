package cn.yumutech.dao.platform;

import java.util.List;

import cn.yumutech.vo.platform.User;

/**
 * 用户mapper
 * 
 * @author zhaowei
 * 
 */
public interface UserMapper {

    /**
     * 获取用户记录
     * 
     * @param user
     * @return
     */
    List<User> selectUserList(User user);
    
    List<User> selectUserByType(String type);

    /**
     * 获取用户记录数
     * 
     * @param user
     * @return
     */
    int selectUserListCount(User user);

    /**
     * 插入用户
     * 
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户
     * 
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * 
     * @param user
     * @return
     */
    int deleteUser(User user);

    /**
     * 获得所有的用户
     * 
     * @return
     */
    List<User> getAllUser();

    /**
     * 判断用户是否存在
     * 
     * @param username
     * @return
     */
    int isUserExist(String username);

    /**
     * 是否enabled(有效性)
     * 
     * @param username
     * @return
     */
    int isUserEnabled(String username);

    /**
     * 登录
     * 
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 更新密码
     * 
     * @param user
     * @return
     */
    int updatePwd(User user);

    /**
     * 更新用户个人信息
     * 
     * @param user
     * @return
     */
    int updateUserPersonalInfo(User user);

    /**
     * 通过用户id取得用户数据
     * 
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /***
     * 重置密码
     * 
     * @param user
     * @return
     */
    int resetPwd(User user);

    /***
     * 根据用户名查询用户ID
     * 
     * @param username
     * @return
     */
    Long selectUserIDByUserName(String username);

}
