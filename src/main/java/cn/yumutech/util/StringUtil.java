package cn.yumutech.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 字符串工具类
 * 
 * @author zhaowei
 * 
 */
public class StringUtil implements Serializable {

    private static final long serialVersionUID = 4352608634839861822L;

    /**
     * 用户状态设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> setYearOption(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        for (int i = 2014; i < 2031; i++) {
            String item = Integer.valueOf(i).toString();
            result.add(new PairItem(item, item));

        }

        return result;
    }

    public static String filterContent(String contentStr) {

        if (contentStr == null || contentStr.length() == 0) {
            return "";
        }
        // 过滤html标签 去除标签 &nbsp;等
        contentStr = contentStr.replaceAll("<[^>]*>", "");
        contentStr = contentStr.replaceAll("\r|\n", "");
        contentStr = contentStr.replaceAll("\\&[a-zA-Z]{1,10};", "");
        // contentStr = contentStr.replaceAll(" ","");

        return contentStr;
    }

    /**
     * 用户状态设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> setUserStatus(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("1", "正常"));
        result.add(new PairItem("0", "非激活"));

        return result;
    }

    /**
     * 部门状态设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> setDeptStatus(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("1", "正常"));
        result.add(new PairItem("0", "撤销"));

        return result;
    }

    /**
     * 父级栏目设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> setParentCategoryList(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("0", "顶级栏目"));
        result.add(new PairItem("1", "|_政策法规"));
        result.add(new PairItem("2", "|_地方法规"));
        result.add(new PairItem("3", "|_地方法规"));
        result.add(new PairItem("4", "|_国家法规"));
        result.add(new PairItem("5", "|_园区风采"));

        return result;
    }

    /**
     * 栏目类别设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> setModelList(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("article", "文章"));
        result.add(new PairItem("link", "友情链接"));

        return result;
    }

    /**
     * 打开方式设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> setTargetList(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("_blank", "单独页面"));
        result.add(new PairItem("_self", "本页面"));

        return result;
    }

    /**
     * 性别设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> setGender(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("1", "男"));
        result.add(new PairItem("2", "女"));

        return result;
    }

    /***
     * 状态设置
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> getStatus(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("1", "启用"));
        result.add(new PairItem("0", "禁用"));

        return result;

    }

    /**
     * 是否默认网站
     * 
     * @return
     */
    public static List<PairItem> getItem() {
        List<PairItem> result = new ArrayList<PairItem>();
        result.add(new PairItem("1", "是"));
        result.add(new PairItem("0", "否"));
        return result;
    }

    /**
     * 是否为空
     * 
     * @param value
     * @return boolean
     */
    public static boolean isEmpty(String value) {
        if (value == null || "".equals(value.trim())) {
            return true;
        }
        return false;
    }

    /***
     * 月份设置
     * 
     * @return
     */
    public static List<PairItem> monthList(boolean empty) {

        List<PairItem> result = new ArrayList<PairItem>();

        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("1", "1月"));
        result.add(new PairItem("2", "2月"));
        result.add(new PairItem("3", "3月"));
        result.add(new PairItem("4", "4月"));
        result.add(new PairItem("5", "5月"));
        result.add(new PairItem("6", "6月"));
        result.add(new PairItem("7", "7月"));
        result.add(new PairItem("8", "8月"));
        result.add(new PairItem("9", "9月"));
        result.add(new PairItem("10", "10月"));
        result.add(new PairItem("11", "11月"));
        result.add(new PairItem("12", "12月"));

        return result;
    }

    /***
     * 获得最近10年
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> year10List(boolean empty) {
        List<PairItem> result = new ArrayList<PairItem>();
        if (empty) {
            result.add(new PairItem("", "请选择"));
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        for (int i = 1; i <= 10; i++) {
            result.add(new PairItem(year - i + 1 + "", year - i + 1 + ""));
        }

        return result;
    }

    /***
     * 最近十年，最近五年
     * 
     * @param empty
     * @return
     */
    public static List<PairItem> yearList(boolean empty) {

        List<PairItem> result = new ArrayList<PairItem>();
        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
        result.add(new PairItem("5", "最近五年"));
        result.add(new PairItem("10", "最近十年"));
        return result;
    }
    
    
    /****
     * 载体出租出售类型
     * @return
     */
    public static List<PairItem> carrierTypeList(boolean empty){
    	
    	List<PairItem> result=new ArrayList<PairItem>();
    	if (empty) {
            result.add(new PairItem("", "请选择"));
        }
    	 result.add(new PairItem("出租", "出租"));
    	 result.add(new PairItem("出售", "出售"));
    	 return result;
    	    	
    }
    
    /****
     * 载体求租求售类型
     * @return
     */
    public static List<PairItem> carrierRequestList(boolean empty){
        
        List<PairItem> result=new ArrayList<PairItem>();
        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
         result.add(new PairItem("求租", "求租"));
         result.add(new PairItem("求售", "求售"));
         return result;
                
    }
    
public static List<PairItem> is_publishedList(boolean empty){
        
        List<PairItem> result=new ArrayList<PairItem>();
        if (empty) {
            result.add(new PairItem("", "请选择"));
        }
         result.add(new PairItem("1", "已发布"));
         result.add(new PairItem("-1", "未发布"));
         return result;
                
    }
public static List<PairItem> is_copyrightList(boolean empty){
    
    List<PairItem> result=new ArrayList<PairItem>();
    if (empty) {
        result.add(new PairItem("", "请选择"));
    }
     result.add(new PairItem("是", "是"));
     result.add(new PairItem("否", "否"));
     return result;
            
}


}
