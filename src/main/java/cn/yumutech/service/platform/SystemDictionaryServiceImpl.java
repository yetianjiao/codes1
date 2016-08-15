/**
 * 
 */
package cn.yumutech.service.platform;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author zhaowei
 * 
 */
@Service
public class SystemDictionaryServiceImpl implements SystemDictionaryService {

    // private static Logger logger =
    // Logger.getLogger(SystemDictionaryServiceImpl.class);

    @Resource
    private SystemOptionService systemOptionService;
    //
    // @Override
    // public List<SystemOption> retriveCapitalPatternJSONData() throws
    // Exception {
    // List<SystemOption> result = new ArrayList<SystemOption>();
    // try {
    // result = systemOptionService.selectSystemOption(SYSTEM_PRODUCT_PSP_LIB,
    // SYSTEM_FIELD_CAPITAL_PATTERN);
    //
    // } catch (Exception e) {
    // logger.error(e.getMessage());
    // throw e;
    // }
    //
    // return result;
    // }
    //
    // private String changetoJSONData(List<SystemOption> origin) throws
    // Exception{
    //
    //
    //
    //
    // List<Object> listmap=new ArrayList<Object>();
    // Map<String, Object> map;
    // for (SystemOption systemOption :origin) {
    // map=new HashMap<String, Object>();
    // map.put("key", category.getId());
    // map.put("pId", category.getPortal_category_id_parent());
    // map.put("open", true);
    // map.put("name", category.getName());
    // listmap.add(map);
    // }
    // JSONArray array=JSONArray.fromObject(listmap);
    // JsonUtil jsonUtil = new JsonUtil();
    // jsonUtil.outJsonString(array.toString());
    // }

}
