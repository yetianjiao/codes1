package cn.yumutech.web.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import cn.yumutech.util.BOConstants;
import cn.yumutech.util.Constants;
import cn.yumutech.util.DateUtils;
import cn.yumutech.util.ValidAlertConstants;
import cn.yumutech.util.VoCanConvToJson;
import cn.yumutech.util.WebConstants;
import cn.yumutech.vo.SearchBaseObject;
import cn.yumutech.vo.platform.User;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.reflect.MethodUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action基类
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class BaseAction extends ActionSupport {

    private static final long serialVersionUID = -9007460799419162724L;

    private Logger logger = Logger.getLogger(BaseAction.class);

    protected final static String PAGE_SEARCH_OBJ = Constants.PAGE_SEARCH_OBJ;

    protected static final String PAGE_SEARCH_OBJ_OTHER = Constants.PAGE_SEARCH_OBJ_OTHER;

    protected final static String SESSION_FAVOURITE = Constants.SESSION_FAVOURITE;

    protected final static String SESSION_USER = Constants.SESSION_USER;

    protected final static String SESSION_PORTAL = Constants.SESSION_PORTAL;
    protected final static String SESSION_PID = Constants.SESSION_PID;

    protected final static String SESSION_USER_RIGHT = Constants.SESSION_USER_RIGHT;

    protected Map<String, Object> session;
    protected String alertInfo;
    protected ServletOutputStream outputStream;
    private int rowNum = 1;

    // 排序用
    private Integer rowCount;
    private Integer pageCount;
    private Integer pageSize = WebConstants.PAGE_SIZE;
    private Integer pageNumber = 1;
    private Integer rowNumberStart;
    private Integer rowNumberEnd;
    private String ascRow;
    private String descRow;

    private File file;
    private String fileContentType;
    private String fileFileName;

    public void setPagingAndSortStart(SearchBaseObject object) {
        //每一页开始的行数
    	rowNumberStart = (pageNumber - 1) * pageSize;
        //每一页结束的行数
        rowNumberEnd = pageNumber * pageSize;

        if (ascRow != null) {
            object.setOrderBy(ascRow + " asc");
        } else if (descRow != null) {
            object.setOrderBy(descRow + " desc");
        }

        object.setOffset(rowNumberStart);
        object.setRow_count(pageSize);

    }

    public void setPagingAndSortEnd(Map<String, Object> result) {
    	//查找结果，要显示的行数
        rowCount = (Integer) result.get(BOConstants.ROW_COUNT);
        //该页结尾的数量
        rowNumberEnd = rowNumberEnd > rowCount ? rowCount : rowNumberEnd;
        //页数
        pageCount = (rowCount + pageSize - 1) / pageSize;

    }

    /**
     * 将列中的数据写入到 缓存中
     * 
     * @param list
     *            查找到的数据
     * @param className
     *            数据中的VO类型
     * @param pr
     *            printWriter 写文件
     * @param dataBuffer
     *            缓存
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @SuppressWarnings("static-access")
    protected <E> void writeColumnsToBuffer(List<Object> list, Class<E> className, PrintWriter pr, StringBuffer dataBuffer, String columnStr) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        String seprator = Constants.EXPORT_FILE_SEPRATOR;
        // 每次查询的条数
        // 查询list的 标题 - title 从配置文件 message.properties 中读出
        // 添加数据
        String columnfrom = getText(columnStr);
        String[] coloums = columnfrom.split(",");
        for (Object entry : list) {
            for (String col : coloums) {
                String firstChar = col.trim().substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstChar + col.substring(1);
                // 构造一个set方法名
                Object invokeMethod = new MethodUtils().invokeMethod(entry, getMethodName, null);
                dataBuffer.append(csvFieldEncoding(invokeMethod == null ? "" : invokeMethod.toString())).append(seprator);
            }
            dataBuffer.append("\n");
        }
        pr.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF }));
        pr.write(dataBuffer.toString());
    }

    /**
     * 处理字符问题
     * 
     * @param item
     * @return
     */
    protected String csvFieldEncoding(String item) {
        if (org.apache.commons.lang.StringUtils.isEmpty(item)) {
            return item;
        }

        item = item.replace('”', '"');
        item = item.replace('“', '"');
        if (item.indexOf('"') < 0 && item.indexOf(',') < 0 && item.indexOf('\n') < 0) {
            return item;
        }

        StringBuffer sb = new StringBuffer(item.length() * 2 + 2);
        sb.append('"');
        for (int ind = 0; ind < item.length(); ind++) {
            char ch = item.charAt(ind);
            if ('"' == ch) {
                sb.append("\"\"");
            } else {
                sb.append(ch);
            }
        }
        sb.append('"');
        return new String(sb);
    }

    /**
     * 将标题写入到 缓存中
     * 
     * @param dataBuffer
     * @param pr
     *            printWriter
     */
    protected void witeTitleToBuffer(StringBuffer dataBuffer, PrintWriter pr, String titlesKey) {
        // 添加标题
        String titlefrom = getText(titlesKey);
        String[] split = titlefrom.split(Constants.EXPORT_FILE_TITLE_SEPRATOR);
        int count = 0;
        if (split != null) {
            for (String title : split) {
                dataBuffer.append(title.trim());
                count++;
                if (split.length != count) {
                    dataBuffer.append(Constants.EXPORT_FILE_SEPRATOR);
                } else {
                    dataBuffer.append("\n");
                }
            }
        }

        pr.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF }));
        pr.write(dataBuffer.toString());
    }

    /**
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    protected PrintWriter getFileWriter() throws UnsupportedEncodingException, IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Expires", "0");
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control", "must-revalidate,post-check=0,pre-check=0");

        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(getText(Constants.OUT_WRITE_CSV_FILENAME), "UTF-8"));
        PrintWriter pr = response.getWriter();
        return pr;
    }

    protected WritableWorkbook getWritableWorkbook() throws UnsupportedEncodingException, IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + DateUtils.getCurrentDateYYYYMMDDHHMMSSContinus() + ".xls");// 设定输出文件头
        response.setContentType("application/msexcel");// 定义输出类型
        outputStream = response.getOutputStream();

        WritableWorkbook wwb = Workbook.createWorkbook(outputStream);
        // 添加第一个工作表并设置第一个Sheet的名字
        // WritableSheet sheet = wwb.createSheet("导出结果", 0); 0 00
        return wwb;
    }

    protected WritableWorkbook getWritableWorkbook(String fileprefix) throws UnsupportedEncodingException, IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileprefix + "_" + DateUtils.getCurrentDateYYYYMMDDHHMMSSContinus() + ".xls", "UTF-8"));// 设定输出文件头
        response.setContentType("application/msexcel");// 定义输出类型
        outputStream = response.getOutputStream();

        WritableWorkbook wwb = Workbook.createWorkbook(outputStream);
        // 添加第一个工作表并设置第一个Sheet的名字
        // WritableSheet sheet = wwb.createSheet("导出结果", 0); 0 00
        return wwb;
    }

    protected void writeExcelTitle(String titlesKey, WritableWorkbook wwb, WritableSheet sheet) {
        try {
            String titlefrom = getText(titlesKey);
            String[] split = titlefrom.split(Constants.EXPORT_FILE_TITLE_SEPRATOR);
            int count = 0;
            Label label;
            if (split != null) {
                WritableCellFormat format = new WritableCellFormat();
                format.setBackground(Colour.GRAY_50);
                for (String title : split) {
                    // Label(x,y,z)其中x代表单元格的第x+1列，第y+1行, 单元格的内容是y
                    // 在Label对象的子对象中指明单元格的位置和内容
                    label = new Label(count, 0, title, format);
                    sheet.addCell(label);
                    count++;
                }
            }
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("static-access")
    protected <E> void writeExcelColumns(List<Object> list, Class<E> className, String columnStr, WritableWorkbook wwb, WritableSheet sheet) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, IOException, WriteException {
        // 每次查询的条数
        // 查询list的 标题 - title 从配置文件 message.properties 中读出
        // 添加数据
        String columnfrom = getText(columnStr);
        String[] coloums = columnfrom.split(",");
        Label label = null;

        for (Object entry : list) {
            if (entry == null) {
                logger.warn("writeExcelColumns entry is null...");
                continue;
            }
            int count = 0;
            for (String col : coloums) {
                String firstChar = col.trim().substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstChar + col.substring(1);
                // 构造一个set方法名
                Object invokeMethod = new MethodUtils().invokeMethod(entry, getMethodName, null);
                String content = "";
                if (invokeMethod != null) {

                    if (invokeMethod instanceof Date) {
                        content = DateUtils.convertToYYYYMMDDHHMMSS((Date) invokeMethod);
                    } else {
                        content = invokeMethod.toString();
                    }
                }

                label = new Label(count++, rowNum, content);
                sheet.addCell(label);
            }
            rowNum++;
        }
    }

    /**
     * 得到 Session
     * 
     * @return Session
     */
    protected Map<String, Object> getSession() {
        session = ActionContext.getContext().getSession();
        return session;
    }

    /**
     * 页面中得到登录用户的信息
     * 
     * @return 登录用户的信息
     */
    protected User getSessionUser() {
        Object object = getSession().get(SESSION_USER);
        return object == null ? null : (User) object;
    }

  

    /**
     * 得到登录用户的indx
     * 
     * @return userIndx
     */
    protected Integer getSessionUserIndx() {
        User sessionUser = getSessionUser();
        if (sessionUser == null)
            return 0;
        else
            return sessionUser.getId();
    }


    // /**
    // * 页面中得到登录用户的 权限信息
    // *
    // * @return 登录用户的权限信息
    // */
    // @SuppressWarnings("unchecked")
    // protected Map<String, SUserModuleRight> getSessionUserRight() {
    // Object object = getSession().get(SESSION_USER_RIGHT);
    // return object == null ? null : (Map<String, SUserModuleRight>) object;
    // }

    /**
     * 清空session 中分页数据
     */
    protected void cleanSession() {
        getSession().remove(PAGE_SEARCH_OBJ);
        getSession().remove(PAGE_SEARCH_OBJ_OTHER);
    }

    /**
     * 替换 getWriter()方法 得到PrintWriter 可以直接向 Response 中写JSON 数据 ACTION中要 return
     * null; 向前台直接写出数据
     * 
     * @param obj
     *            负责写出的数据
     */
    protected void writerPrint(Object obj) {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(obj);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * get the parameter from request
     * 
     * @param parameter
     * @return
     */
    protected String getParameter(String parameter) {
        Map<String, Object> parameters = ActionContext.getContext().getParameters();
        String[] object = (String[]) parameters.get(parameter);
        return object == null ? null : object[0];
    }

    /**
     * get the parameter from request
     * 
     * @param parameter
     * @return
     */
    protected Integer getParameter4Int(String parameter) {
        Map<String, Object> parameters = ActionContext.getContext().getParameters();
        String[] object = (String[]) parameters.get(parameter);
        if (object == null) {
            return null;
        }

        Integer value = null;
        try {
            value = Integer.parseInt(object[0]);
        } catch (Exception e) {
        }

        return value;
    }

    protected String[] getParameters(String parameter) {
        Map<String, Object> parameters = ActionContext.getContext().getParameters();
        return (String[]) parameters.get(parameter);
    }

    protected Map<String, Object> getParametersAll() {
        return ActionContext.getContext().getParameters();
    }

    // /**
    // * 写出数据 {id:indx ,value:xxxx}
    // *
    // * @param dictionaryBo
    // * 查助记码的BO 需要继承 IDictionaryBo
    // * @param type
    // * 查不同的助记码 type 定义在 DictionaryConstants中
    // */
    // protected void getMemory(IDictionaryBo dictionaryBo, int type) {
    // String memoryCode = getParameter("indx");
    // String searchBy = getParameter("searchBy");
    // DictionaryVO dictionaryVO = null;
    // boolean isSearchByIndx = searchBy != null
    // && MEMORY_CODE_BY_INDEX.equals(searchBy);
    // try {
    // if (isSearchByIndx) {
    // dictionaryVO = dictionaryBo.getMemoryByIndx(memoryCode, type);
    // } else {
    // dictionaryVO = dictionaryBo.getMemory(memoryCode, type);
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // if (dictionaryVO != null) {
    // Map<Object, Object> map = new HashMap<Object, Object>();
    // map.put("id", dictionaryVO.getIndx());
    // map.put("memoryCode", dictionaryVO.getMemoryCode());
    // map.put("value", dictionaryVO.getMemoryText());
    //
    // String jsonstring = makeJsonString(map);
    // debug(" dictionaryVO -json->:" + jsonstring);
    // writerPrint(jsonstring);
    // } else {
    // writerPrint("{\"id\":\"-1\",\"memoryCode\":\"null\",\"value\":\"null\"}");
    // }
    // }

    /**
     * 填入一个 hashMap 生成json格式的数据
     * 
     * @param jsonMap
     */
    protected String makeJsonString(Map<Object, Object> jsonMap) {
        if (jsonMap == null || jsonMap.isEmpty()) {
            error("makeJsonString error,jsonMap is null || is empty");
            return null;
        }
        Set<Object> keySet = jsonMap.keySet();
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        Iterator<Object> iterator = keySet.iterator();
        boolean hasNext = iterator.hasNext();
        while (hasNext) {
            Object next = iterator.next();
            sb.append("\"" + next + "\":");
            Object object = jsonMap.get(next);
            sb.append("\"" + object + "\"");
            hasNext = iterator.hasNext();
            if (hasNext) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 把一个对象所对应的属性值，生成json 格式数据
     */
    protected <E> String makeVOtoJson(E element) {
        Class<? extends Object> class1 = element.getClass();
        Field[] fields = class1.getDeclaredFields();
        if (fields == null || fields.length == 0) {
            error("makeVOtoJson error,no Field  found || is empty");
            return null;
        }
        Map<Object, Object> map = new HashMap<Object, Object>();
        for (Field f : fields) {
            String name = f.getName();
            String getter = "get" + StringUtils.capitalize(name);
            try {
                Method method = element.getClass().getMethod(getter);
                Object invoke = method.invoke(element);
                map.put(name, invoke);
            } catch (SecurityException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        String makeJsonString = makeJsonString(map);
        debug("makeVOtoJson JsonString-->" + makeJsonString);
        return makeJsonString;
    }

    public void responseIdValue(String id, String value) {
        Map<Object, Object> jsonMap = new HashMap<Object, Object>();
        jsonMap.put("id", id);
        jsonMap.put("value", value);
        String makeJsonString = makeJsonString(jsonMap);
        logger.debug("jsonString->" + makeJsonString);
        writerPrint(makeJsonString);
    }

    /**
     * 向前台 返回 {id:"1",value:"common successInfo"} 数据，
     */
    public void responseSuccess() {
        responseSuccess(ValidAlertConstants.COMMON_SAVE_SUCC);
    }

    /**
     * 向前台 返回 " {id:"1",value:"certain successInfo (key所对应的value)"}" 数据，
     * 
     * @param key
     *            struts *.properties 中的key及 {@link ValidAlertConstants}中的数据
     */
    public void responseSuccess(String key) {
        responseIdValue(ValidAlertConstants.COMMON_SAVE_SUCC_ID, getText(key));
    }

    /**
     * 向前台 返回 {id:"-1",value:"common failInfo"} 数据，
     */
    public void responseFail() {
        responseFail(ValidAlertConstants.COMMON_SAVE_FAIL);
    }

    /**
     * 向前台 返回 {id:"-1",value:"certain failInfo (key所对应的value)"} 数据
     * 
     * @param key
     *            struts *.properties 中的key及 {@link ValidAlertConstants}中的数据
     */
    public void responseFail(String key) {
        responseIdValue(ValidAlertConstants.COMMON_SAVE_FAIL_ID, getText(key));
    }

    public void responseWarnMsg() {
        responseWarnMsg(ValidAlertConstants.COMMON_SAVE_FAIL);
    }

    /**
     * 
     * @param key
     */
    public void responseWarnMsg(String key) {
        responseIdValue(ValidAlertConstants.COMMON_SAVE_WARN_ID, getText(key));
    }

    public void debug(Object o) {
        if (logger.isDebugEnabled()) {
            logger.debug(o);
        }
    }

    public void info(Object o) {
        if (logger.isInfoEnabled()) {
            logger.info(o);
        }
    }

    public void warn(Object o) {
        logger.warn(o);
    }

    public void error(Object o) {
        logger.error(o);
    }

    public String getAlertInfo() {
        return alertInfo;
    }

    public void setAlertInfo(String alertInfo) {
        this.alertInfo = alertInfo;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String makeListtoJSON(List<VoCanConvToJson> list) {
        String json = "{v:[";
        for (int i = 0; i < list.size(); i++) {
            json = json + list.get(i).toJSON();
            if (i != list.size() - 1) {
                json = json + ",";
            }
        }
        json = json + "]}";
        return json;
    }

    public String getclientIP() {

        // HttpServletRequest req = (HttpServletRequest) ServletActionContext
        // .getRequest();
        // String ipaddress = req.getRemoteAddr();

        Object ip = ServletActionContext.getRequest().getHeader("X-Forwarded-For".toLowerCase());
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("Proxy-Client-IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("WL-Proxy-Client-IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("HTTP_CLIENT_IP".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getHeader("HTTP_X_FORWARDED_FOR".toLowerCase());
        }
        if (ip == null || "unknown".equalsIgnoreCase(ip.toString())) {
            ip = ServletActionContext.getRequest().getRemoteAddr();
        }

        return ip == null ? "" : ip.toString();

    }

    /**
     * @return the rowNum
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * @param rowNum
     *            the rowNum to set
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    /**
     * @return the rowCount
     */
    public Integer getRowCount() {
        return rowCount;
    }

    /**
     * @param rowCount
     *            the rowCount to set
     */
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    /**
     * @return the pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount
     *            the pageCount to set
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pageNumber
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber
     *            the pageNumber to set
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the rowNumberStart
     */
    public Integer getRowNumberStart() {
        return rowNumberStart;
    }

    /**
     * @param rowNumberStart
     *            the rowNumberStart to set
     */
    public void setRowNumberStart(Integer rowNumberStart) {
        this.rowNumberStart = rowNumberStart;
    }

    /**
     * @return the rowNumberEnd
     */
    public Integer getRowNumberEnd() {
        return rowNumberEnd;
    }

    /**
     * @param rowNumberEnd
     *            the rowNumberEnd to set
     */
    public void setRowNumberEnd(Integer rowNumberEnd) {
        this.rowNumberEnd = rowNumberEnd;
    }

    /**
     * @return the ascRow
     */
    public String getAscRow() {
        return ascRow;
    }

    /**
     * @param ascRow
     *            the ascRow to set
     */
    public void setAscRow(String ascRow) {
        this.ascRow = ascRow;
    }

    /**
     * @return the descRow
     */
    public String getDescRow() {
        return descRow;
    }

    /**
     * @param descRow
     *            the descRow to set
     */
    public void setDescRow(String descRow) {
        this.descRow = descRow;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file
     *            the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the fileContentType
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * @param fileContentType
     *            the fileContentType to set
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    /**
     * @return the fileFileName
     */
    public String getFileFileName() {
        return fileFileName;
    }

    /**
     * @param fileFileName
     *            the fileFileName to set
     */
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

}
