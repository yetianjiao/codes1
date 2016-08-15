package cn.yumutech.web.converter;

import java.util.Map;

import cn.yumutech.util.ValidAlertConstants;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Integer转换器
 * 
 * @author zhaowei
 * 
 */
public class IntegerConverter extends StrutsTypeConverter {

    @SuppressWarnings("rawtypes")
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values == null || values.length == 0) {
            return null;
        }
        // 有时分秒的要先转换
        String intString = values[0];
        intString = intString.replaceAll("\"", "");
        int res = ValidAlertConstants.INVALID_MEMORY_NO;
        if (intString == null || "".equalsIgnoreCase(intString)) {
            intString = String.valueOf(ValidAlertConstants.INVALID_MEMORY_NO);
        }
        if (toClass == Integer.class) {
            res = Integer.parseInt(intString);
        } else if (toClass.toString().equals("int")) {
            res = Integer.parseInt(intString);
        }
        return res;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util
     * .Map, java.lang.Object)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public String convertToString(Map arg0, Object arg1) {
        return null;
    }

}