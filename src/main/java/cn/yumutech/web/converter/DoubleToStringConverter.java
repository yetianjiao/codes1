package cn.yumutech.web.converter;

import java.text.DecimalFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Double转换器
 * 
 * @author zhaowei
 * 
 */
public class DoubleToStringConverter extends StrutsTypeConverter {

    @SuppressWarnings("rawtypes")
    @Override
    public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
        return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String convertToString(Map arg0, Object arg1) {
        Double value = (Double) arg1;
        DecimalFormat format = new DecimalFormat("0.0000");
        String result = format.format(value);
        return result;
    }

}
