package cn.yumutech.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author zhaowei
 * 
 */
public class DateUtils implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = -7968262747262488161L;
    public final static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public final static String YYYYMMDDHHMMSS_CONTINUS = "yyyyMMddHHmmss";
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String YYYY = "yyyy";
    public static final String YYYYMM = "yyyy-MM";
    public static final String YYMM = "yyMM";

    public static final String HHmm = "HH:mm";

    /**
     * 将日期转换成字符串，转换后的格式为：yyyy-MM-dd HH:mm:ss，如果日期为null则返回“”
     * 
     * @param date
     * @return
     */
    public static String convertToYYYYMMDDHHMMSS(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
        return sdf.format(date);
    }

    /**
     * 将日期转换成字符串，转换后的格式为：yyyyMMddHHmmss，如果日期为null则返回“”
     * 
     * @param date
     * @return
     */
    public static String convertToYYYYMMDDHHMMSSContinus(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS_CONTINUS);
        return sdf.format(date);
    }

    /**
     * 将日期转换成字符串，转换后的格式为：yyyy-MM-dd，如果日期为null则返回“”
     * 
     * @param date
     * @return
     */
    public static String convertToYYYYMMDD(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        return sdf.format(date);
    }

    /**
     * 将日期转换成字符串，转换后的格式为：yyMM，如果日期为null则返回“”
     * 
     * @param date
     * @return
     */
    public static String convertToYYMM(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(YYMM);
        return sdf.format(date);
    }

    /**
     * 将当前日期转换成字符串，转换后的格式为：yyyy-MM-dd，如果日期为null则返回“”
     * 
     * @return
     */
    public static String getCurrentDateYYYYMMDD() {
        return convertToYYYYMMDD(new Date());
    }

    /**
     * 将当前日期转换成字符串，转换后的格式为：yyyy-MM-dd HH:mm:ss，如果日期为null则返回“”
     * 
     * @return
     */
    public static String getCurrentDateYYYYMMDDHHMMSS() {
        return convertToYYYYMMDDHHMMSS(new Date());
    }

    /**
     * 将当前日期转换成字符串，转换后的格式为：yyyyMMddHHmmss，如果日期为null则返回“”
     * 
     * @return
     */
    public static String getCurrentDateYYYYMMDDHHMMSSContinus() {
        return convertToYYYYMMDDHHMMSSContinus(new Date());
    }

    /**
     * 将当前日期转换成字符串，转换后的格式为：yyMM，如果日期为null则返回“”
     * 
     * @return
     */
    public static String getCurrentDateYYMM() {
        return convertToYYMM(new Date());
    }

    // public static void main(String[] args){
    // String currentDateYYMM = getCurrentDateYYMM();
    // System.out.println(currentDateYYMM);
    // }

    /**
     * 将日期转换成字符串，转换后的格式为：HH:mm，如果日期为null则返回“” HH:mm format eg. 10:20
     * 
     * @param date
     * @return
     */
    public static String convertToHHmm(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(HHmm);
        return sdf.format(date);
    }

    /**
     * 将字符串（格式：yyyy-MM-dd HH:mm:ss）转化为日期，如果格式不对，则返回null
     * 
     * @param original
     * @return
     * @throws ParseException
     */
    public static Date convertToDateyyyyMMddHHmmss(String original) throws ParseException {
        Date result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
            result = sdf.parse(original);

        } catch (ParseException e) {
            return null;
        }

        return result;

    }

    /**
     * 将字符串（格式：yyyy-MM-dd HH:mm）转化为日期，如果格式不对，则返回null
     * 
     * @param original
     * @return
     * @throws ParseException
     */
    public static Date convertToDateyyyyMMddHHmm(String original) throws ParseException {
        Date result = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMM);
            result = sdf.parse(original);

        } catch (ParseException e) {
            return null;
        }

        return result;

    }

    /**
     * 将字符串（格式：yyyy-MM-dd）转化为日期，如果格式不对，则返回null
     * 
     * @param original
     * @return
     * @throws ParseException
     */
    public static Date convertToDateyyyyMMdd(String original) throws ParseException {

        Date result = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
            result = sdf.parse(original);

        } catch (ParseException e) {
            return null;
        }

        return result;

    }

    /**
     * 将字符串（格式：yyyy-MM）转化为日期，如果格式不对，则返回null
     * 
     * @param original
     * @return
     * @throws ParseException
     */
    public static Date convertToDateyyyyMM(String original) throws ParseException {

        Date result = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYYMM);
            result = sdf.parse(original);

        } catch (ParseException e) {
            return null;
        }

        return result;

    }

    /**
     * 将字符串（格式：yyyy）转化为日期，如果格式不对，则返回null
     * 
     * @param original
     * @return
     * @throws ParseException
     */
    public static Date convertToDateyyyy(String original) throws ParseException {

        Date result = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY);
            result = sdf.parse(original);

        } catch (ParseException e) {
            return null;
        }

        return result;

    }

    /**
     * 
     * 得到本月的第一天
     */

    public static Date getCurrentMonthFirstDay() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, calendar

        .getActualMinimum(Calendar.DAY_OF_MONTH));

        // calendar.set( Calendar.DATE, 1);
        return calendar.getTime();

    }

    /**
     * 
     * 得到本月的最后一天
     */

    public static Date getCurrentMonthLastDay() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, calendar

        .getActualMaximum(Calendar.DAY_OF_MONTH));

        return calendar.getTime();

    }

    /**
     * 
     * 得到指定月的最后一天
     */

    public static Date getMonthLastDay(Long ms) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);

        // calendar.set(Calendar.DAY_OF_MONTH, 1);

        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();

    }

    /**
     * 
     * 得到指定月的第一天
     */

    public static Date getMonthFirstDay(Long ms) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ms);

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // calendar.add(Calendar.MONTH, 1);
        // calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();

    }

    /**
     * 获得明天日期
     * 
     * @param currentday
     * @return
     */
    public static Date getNextDay(Date currentday) {

        // 明天日期
        Date nextday = new Date();
        long nexttime = (currentday.getTime() / 1000) + 60 * 60 * 24;
        nextday.setTime(nexttime * 1000);
        return nextday;
    }

    /***
     * 时间戳转换为Date
     * 
     * @param date
     * @return
     */
    public static Date getLongDate(Long date) {
        Date dd = new Date(date);
        return dd;
    }

    public static void main(String[] args) throws ParseException {
        System.out.print(getMonthLastDay(new Date().getTime()));
    }

}
