/**
 * 
 */
package cn.yumutech.service.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.yumutech.dao.platform.SystemOptionMapper;
import cn.yumutech.util.BOConstants;
import cn.yumutech.vo.platform.SystemOption;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统选项Service实现类
 * 
 * @author zhaowei
 * 
 */
@Service
public class SystemOptionServiceImpl implements SystemOptionService {

    private static Logger logger = Logger.getLogger(SystemOptionServiceImpl.class);

    @Resource
    private SystemOptionMapper systemOptionMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemOptionService# selectSystemOptionByFieldID(int)
     */
    @Override
    public List<SystemOption> selectSystemOptionByFieldID(int system_field_id) throws Exception {
        List<SystemOption> result = new ArrayList<SystemOption>();
        try {
            result = systemOptionMapper.selectSystemOptionByFieldID(system_field_id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemOptionService# selectSystemOptionByFieldIDList(int)
     */
    @Override
    public Map<String, Object> selectSystemOptionByFieldIDList(int system_field_id) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        try {

            result.put(BOConstants.ROW_COUNT, systemOptionMapper.selectSystemOptionByFieldIDCount(system_field_id));
            result.put(BOConstants.VALUE_LIST, systemOptionMapper.selectSystemOptionByFieldID(system_field_id));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemOptionService#insertSystemOption (com.xiaoguo.psp.cms.vo.base.SystemOption)
     */
    @Override
    @Transactional
    public int insertSystemOption(SystemOption systemOption) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(systemOption);
        }
        int result = 0;
        try {
            result = systemOptionMapper.insertSystemOption(systemOption);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemOptionService#updateSystemOption (com.xiaoguo.psp.cms.vo.base.SystemOption)
     */
    @Override
    @Transactional
    public int updateSystemOption(SystemOption systemOption) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(systemOption);
        }
        int result = 0;
        try {
            result = systemOptionMapper.updateSystemOption(systemOption);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemOptionService#deleteSystemOption (int)
     */
    @Override
    @Transactional
    public int deleteSystemOption(int id) throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info(id);
        }
        int result = 0;
        try {
            result = systemOptionMapper.deleteSystemOption(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemOptionService#selectSystemOption (java.lang.String, java.lang.String)
     */
    @Override
    public List<SystemOption> selectSystemOption(String system_product_code, String system_field_code) throws Exception {
        List<SystemOption> result = new ArrayList<SystemOption>();
        try {
            result = systemOptionMapper.selectSystemOption(system_product_code, system_field_code);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemOptionService# selectSystemOptionForId(int)
     */
    @Override
    public SystemOption selectSystemOptionForId(int id) throws Exception {

        if (logger.isInfoEnabled()) {
            logger.info(id);
        }
        SystemOption systemOption = new SystemOption();

        try {
            systemOption = systemOptionMapper.selectSystemOptionForId(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return systemOption;

    }

}
