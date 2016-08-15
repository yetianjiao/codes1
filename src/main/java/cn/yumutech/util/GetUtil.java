package cn.yumutech.util;

import java.util.UUID;

/***
 * 获取GUID工具类
 * 
 * @author tangjiale
 * 
 */
public class GetUtil {

    /***
     * 获取GUID
     * 
     * @return
     */
    public static String getUUID() {

        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
