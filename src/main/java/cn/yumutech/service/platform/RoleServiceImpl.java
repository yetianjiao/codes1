package cn.yumutech.service.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.yumutech.dao.platform.RoleMapper;
import cn.yumutech.util.BOConstants;
import cn.yumutech.vo.platform.Role;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 角色管理Service实现类
 * 
 * @author zhaowei
 * 
 */
@Service
public class RoleServiceImpl implements RoleService {

    private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Map<String, Object> selectRoleList(Role role) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(role);
        }
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result.put(BOConstants.ROW_COUNT, roleMapper.selectRoleListCount(role));
            result.put(BOConstants.VALUE_LIST, roleMapper.selectRoleList(role));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    @Override
    public List<Role> getAllRole() throws Exception {
        List<Role> result = new ArrayList<Role>();
        try {
            result = roleMapper.getAllRole();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    @Override
    public List<Role> selectRoleListForId(int role_id) {

        if (logger.isInfoEnabled()) {
            logger.info(role_id);
        }
        List<Role> result = new ArrayList<Role>();
        try {
            result = roleMapper.selectRoleListForId(role_id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

}
