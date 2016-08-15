package cn.yumutech.vo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import cn.yumutech.util.WebConstants;

/**
 * 模型基础类（分页）
 * 
 * @author zhaowei
 */
public class SearchPageObject implements Serializable {

    private static final long serialVersionUID = -6217441067788888076L;

    /**
     * 排序
     */
    protected String orderBy;

    /**
     * 偏移量
     */
    protected int offset = 0;

    /**
     * 显示行数
     */
    protected int row_count;

    // 排序用
    protected int pageCount;
    protected int pageSize = WebConstants.PAGING_SIZE_LOW;
    protected int pageNumber = 1;
    protected int rowNumberStart;
    protected int rowNumberEnd;
    protected String ascRow;
    protected String descRow;

    public void pageResize(int rowCount) {
        row_count = rowCount;
        pageCount = (row_count + pageSize - 1) / pageSize;
        rowNumberEnd = rowNumberEnd > row_count ? row_count : rowNumberEnd;
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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        if (pageNumber == 0)
            this.pageNumber = 1;
    }

    public int getRowNumberStart() {
        return rowNumberStart;
    }

    public void setRowNumberStart(int rowNumberStart) {
        this.rowNumberStart = rowNumberStart;
    }

    public int getRowNumberEnd() {
        return rowNumberEnd;
    }

    public void setRowNumberEnd(int rowNumberEnd) {
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the orderBy
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy
     *            the orderBy to set
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset
     *            the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return the row_count
     */
    public int getRow_count() {
        return row_count;
    }

    /**
     * @param row_count
     *            the row_count to set
     */
    public void setRow_count(int row_count) {
        this.row_count = row_count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SearchPageObject [orderBy=");
        builder.append(orderBy);
        builder.append(", offset=");
        builder.append(offset);
        builder.append(", row_count=");
        builder.append(row_count);
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
        builder.append("]");
        return builder.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

}
