package cn.yumutech.web.action;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.yumutech.util.WebConstants;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 翻页基类
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class PageBaseAction<E> extends BaseAction {

    private static final long serialVersionUID = -6139082052445362349L;

    protected Integer rowCount;
    protected Integer pageCount;
    protected Integer pageSize = WebConstants.PAGING_SIZE;
    protected Integer pageNumber = 1;
    protected Integer rowNumberStart;
    protected Integer rowNumberEnd;
    protected String ascRow;
    protected String descRow;
    protected String indx;
    protected String checkValid;
    // 列表选中indx
    protected List<String> filters;

    /**
     * 列表中的标题 从DB中得到在ACTION中初始化
     */
    protected List<String> titles = new ArrayList<String>();

    /**
     * 更新页码信息
     */
    protected void pageResize() {
        rowNumberEnd = rowNumberEnd > rowCount ? rowCount : rowNumberEnd;
        pageCount = (rowCount + pageSize - 1) / pageSize;
    }

    /**
     * 初始化分页信息 设置排序字段 + asc | desc
     */
    @SuppressWarnings("unchecked")
    protected E pageInitEnglish(E searchObj) {
        Map<String, Object> session = getSession();
        String parameter = getParameter("pageNumber");
        if (pageNumber == null)
            pageNumber = 1;
        rowNumberStart = (pageNumber - 1) * pageSize;
        rowNumberEnd = pageNumber * pageSize;
        String args = null;
        if (searchObj == null) {
            // 点下了分页 && parameter != null
            // 点击了排序 ascRow!=null||descRow!=null
            searchObj = (E) session.get(PAGE_SEARCH_OBJ);
            if (parameter != null || ascRow != null || descRow != null) {
                if (ascRow != null) {
                    args = ascRow + " asc";
                } else if (descRow != null) {
                    args = descRow + " desc";
                }
            }
        } else {
            // 用户点击搜索 存放搜索条件
            session.put(PAGE_SEARCH_OBJ, searchObj);
        }

        if (searchObj == null)
            return null;
        try {
            Class<?> superclass = searchObj.getClass();
            Method setOrderBy = superclass.getMethod("setOrderBy", String.class);
            Method setOffset = superclass.getMethod("setOffset", int.class);
            Method setRow_count = superclass.getMethod("setRow_count", int.class);
            setOrderBy.invoke(searchObj, args);
            setOffset.invoke(searchObj, rowNumberStart);
            setRow_count.invoke(searchObj, pageSize);
        } catch (SecurityException e1) {
            e1.printStackTrace();
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return searchObj;
    }

    /**
     * 初始化分页信息 设置排序字段 (排序的字段在DB中是中文 ，所以要先转码)+ asc | desc
     */
    protected E pageInitChinese(E searchObj) {
        chTileSort();
        return pageInitEnglish(searchObj);
    }

    /**
     * 针对视图中字段为中文 sortby 中文进行编码
     */
    protected void chTileSort() {
        try {
            if (ascRow != null && !"".equals(ascRow))
                ascRow = "`" + URLDecoder.decode(ascRow, "UTF-8") + "`";
            if (descRow != null && !"".equals(descRow))
                this.descRow = "`" + URLDecoder.decode(descRow, "UTF-8") + "`";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getIndx() {
        return indx;
    }

    public void setIndx(String indx) {
        this.indx = indx;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getRowNumberStart() {
        return rowNumberStart;
    }

    public void setRowNumberStart(Integer rowNumberStart) {
        this.rowNumberStart = rowNumberStart;
    }

    public Integer getRowNumberEnd() {
        return rowNumberEnd;
    }

    public void setRowNumberEnd(Integer rowNumberEnd) {
        this.rowNumberEnd = rowNumberEnd;
    }

    public String getAscRow() {
        return ascRow;
    }

    public void setAscRow(String ascRow) {
        this.ascRow = ascRow;
    }

    public String getDescRow() {
        return descRow;
    }

    public void setDescRow(String descRow) {
        this.descRow = descRow;
    }

    public String getCheckValid() {
        return checkValid;
    }

    public void setCheckValid(String checkValid) {
        this.checkValid = checkValid;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PageBaseAction [rowCount=");
        builder.append(rowCount);
        builder.append(", pageCount=");
        builder.append(pageCount);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", pageNumber=");
        builder.append(pageNumber);
        builder.append(", rowNumberStart=");
        builder.append(rowNumberStart);
        builder.append(", rowNumberEnd=");
        builder.append(rowNumberEnd);
        builder.append(", ascRow=");
        builder.append(ascRow);
        builder.append(", descRow=");
        builder.append(descRow);
        builder.append(", indx=");
        builder.append(indx);
        builder.append(", checkValid=");
        builder.append(checkValid);
        builder.append(", filters=");
        builder.append(filters);
        builder.append(", session=");
        builder.append(session);
        builder.append(", titles=");
        builder.append(titles);
        builder.append("]");
        return builder.toString();
    }

}
