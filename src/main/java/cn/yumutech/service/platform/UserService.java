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

import java.util.List;
import java.util.Map;

import cn.yumutech.vo.platform.RightTemplate;
import cn.yumutech.vo.platform.RoleRight;
import cn.yumutech.vo.platform.User;

/**
 * 用户管理Service接口
 * 
 * @author zhaowei
 * 
 */
public interface UserService {

	/**
	 * 获得用户数据
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selectUserList(User user) throws Exception;

	/**
	 * 插入用户数据
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int insertUser(User user) throws Exception;
	
	List<User> selectUserByType(String type) throws Exception;

	/**
	 * 修改用户数据
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int updateUser(User user) throws Exception;

	/**
	 * 删除用户数据
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int deleteUser(User user) throws Exception;
	
	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User login(User user) throws Exception;

	/**
	 * check密码
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User checkPassword(User user) throws Exception;

	/**
	 * 修改密码
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int updatePwd(User user) throws Exception;

	/**
	 * check用户是否可用
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean checkUserIsEnabled(User user) throws Exception;

	

	/**
	 * 获得所有用户数据
	 * 
	 * @return
	 * @throws Exception
	 */
	List<User> selectAllUser() throws Exception;

	/**
	 * 修改用户个人数据
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int updateUserPersonalInfo(User user) throws Exception;

	/**
	 * 根据id获得用户数据
	 * 
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	User selectUserById(Integer id) throws Exception;

	/***
	 * 重置密码
	 * 
	 * @param user
	 * @return
	 */
	int resetPwd(User user) throws Exception;

	/***
	 * 根据用户名查询用户ID
	 * 
	 * @param user_name
	 * @return
	 */
	Long selectUserIDByUserName(String username) throws Exception;
	
	
	/**
	 * 判断用户是否存在
	 * 
	 * @param id
	 * @return
	 */
    int isUserExist(String username) throws Exception;

    List<RightTemplate> selectRoleRightList(Integer role_id) throws Exception;

    int insertRoleRight(RoleRight roleRight) throws Exception;

    int deleteRoleRightByRoleId(int role_id) throws Exception;

    List<RightTemplate> selectUserRightForCommon(Integer user_id) throws Exception;

    List<RightTemplate> selectUserRightForAdmin() throws Exception;
    
    int insertRoleRightBatch(RoleRight roleRight) throws Exception;

}
