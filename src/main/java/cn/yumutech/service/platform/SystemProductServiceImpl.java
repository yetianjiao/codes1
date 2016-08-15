/**
 * 
 */
package cn.yumutech.service.platform;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import cn.yumutech.dao.platform.SystemProductMapper;
import cn.yumutech.vo.platform.SystemProduct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 系统产品Service实现类
 * 
 * @author zhaowei
 * 
 */
@Service
public class SystemProductServiceImpl implements SystemProductService {

    private static Logger logger = Logger.getLogger(SystemProductServiceImpl.class);

    @Resource
    private SystemProductMapper systemProductMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xiaoguo.psp.cms.service.platform.SystemProductService#getAllSystemProduct
     * ()
     */
    @Override
    public List<SystemProduct> getAllSystemProduct() throws Exception {
        List<SystemProduct> result = new ArrayList<SystemProduct>();
        try {
            result = systemProductMapper.getAllSystemProduct();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xiaoguo.psp.cms.service.platform.SystemProductService#
     * selectSystemProductByCode(java.lang.String)
     */
    @Override
    public SystemProduct selectSystemProductByCode(String code) throws Exception {
        SystemProduct result = new SystemProduct();
        try {
            result = systemProductMapper.selectSystemProductByCode(code);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

        return result;
    }

}
