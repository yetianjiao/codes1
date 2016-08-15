package cn.yumutech.web.converter;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * BigDevimal转换器
 * 
 * @author zhaowei
 * 
 */
public class BigDecimalConverter extends StrutsTypeConverter {

    @SuppressWarnings("rawtypes")
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values == null || values.length == 0) {
            return null;
        }
        // 有时分秒的要先转换
        String bigDecimalString = values[0];
        if ("".equalsIgnoreCase(bigDecimalString))
            bigDecimalString = "0";
        BigDecimal res = null;
        if (toClass == java.math.BigDecimal.class) {
            double parseDouble = Double.parseDouble(bigDecimalString);
            // long parseLong = Long.parseLong(bigDecimalString);
            res = BigDecimal.valueOf(parseDouble);
            res = BigDecimal.valueOf(parseDouble);
        }
        return res;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String convertToString(Map arg0, Object arg1) {
        if (arg1 == null)
            return "0";
        return String.valueOf(arg1);
    }

}