package cn.yumutech.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 日期转换器
 * 
 * @author zhaowei
 * 
 */
public class DateConverter extends StrutsTypeConverter {
    private static final String FORMATDATE = "yyyy-MM-dd";
    private static final String FORMATDATE_SHORT = "yyyyMMdd";
    private static final String FORMATTIME = "yyyy-MM-dd HH:mm:ss";
    private Logger logger = Logger.getLogger(this.getClass());

    @SuppressWarnings("rawtypes")
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values == null || values.length == 0) {
            return null;
        }

        // 有时分秒的要先转换
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATTIME);
        SimpleDateFormat sdf_short = new SimpleDateFormat(FORMATTIME);
        Date date = null;
        String dateString = values[0];
        if (dateString != null && !"".equals(dateString)) {
            try {
                if (dateString.length() >= 8) {
                    date = sdf.parse(dateString);
                } else {
                    logger.warn("date string is too short");
                }
            } catch (ParseException e) {
                date = null;
            }
            if (date == null) {
                sdf = new SimpleDateFormat(FORMATDATE);
                sdf_short = new SimpleDateFormat(FORMATDATE_SHORT);
                try {
                    if (dateString.length() == 8) {
                        date = sdf_short.parse(dateString);
                    } else if (dateString.length() == 10) {
                        date = sdf.parse(dateString);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    date = null;
                }
            }
        }
        return date;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String convertToString(Map context, Object o) {
        if (o instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(FORMATTIME);
            String format = sdf.format((Date) o);
            // System.out.println("@@@@@@@@@@@@@@@@@@@:"+format);
            return format;
        }
        return "";
    }

}