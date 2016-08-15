/**
 * 
 */
package cn.yumutech.service.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.yumutech.dao.platform.SystemFieldMapper;
import cn.yumutech.util.BOConstants;
import cn.yumutech.vo.platform.SystemField;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 系统分类Service实现类
 * 
 * @author zhaowei
 * 
 */
@Service
public class SystemFieldServiceImpl implements SystemFieldService {

    private static Logger logger = Logger.getLogger(SystemFieldServiceImpl.class);

    @Resource
    private SystemFieldMapper systemFieldMapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemFieldService# selectSystemFieldByProductCode(java.lang.String)
     */
    @Override
    public List<SystemField> selectSystemFieldByProductCode(String system_product_code) throws Exception {
        List<SystemField> result = new ArrayList<SystemField>();
        try {
            result = systemFieldMapper.selectSystemFieldByProductCode(system_product_code);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemFieldService#selectSystemFieldAll ()
     */
    @Override
    public List<SystemField> selectSystemFieldAll() throws Exception {
        List<SystemField> result = new ArrayList<SystemField>();
        try {
            result = systemFieldMapper.selectSystemFieldAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemFieldService# selectSystemFieldByProductCode(java.lang.String)
     */
    @Override
    public Map<String, Object> selectSystemFieldByProductCodeList(String system_product_code) throws Exception {

        Map<String, Object> result = new HashMap<String, Object>();
        try {
            result.put(BOConstants.ROW_COUNT, systemFieldMapper.selectSystemFieldByProductCodeCount(system_product_code));
            result.put(BOConstants.VALUE_LIST, systemFieldMapper.selectSystemFieldByProductCode(system_product_code));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

}
