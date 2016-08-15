package cn.yumutech.vo;

import java.io.Serializable;

/**
 * 模型基础类
 * 
 * @author zhaowei
 * 
 */
public class SearchBaseObject implements Serializable {

    private static final long serialVersionUID = -6217441067788888076L;

    /**
     * 排序
     */
    private String orderBy;

    /**
     * 偏移量
     */
    private int offset = 1;

    /**
     * 显示行数
     */
    private int row_count;

    /***
     * 关键字条件
     */
    private String keyword_condition;

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

    /**
     * @return the keyword_condition
     */
    public String getKeyword_condition() {
        return keyword_condition;
    }

    /**
     * @param keyword_condition
     *            the keyword_condition to set
     */
    public void setKeyword_condition(String keyword_condition) {
        this.keyword_condition = keyword_condition;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SearchBaseObject [orderBy=");
        builder.append(orderBy);
        builder.append(", offset=");
        builder.append(offset);
        builder.append(", row_count=");
        builder.append(row_count);
        builder.append(", keyword_condition=");
        builder.append(keyword_condition);
        builder.append("]");
        return builder.toString();
    }

}
