/**
 * 
 */
package cn.yumutech.vo.platform;

import cn.yumutech.vo.SearchBaseObject;

/**
 * 系统产品模型
 * 
 * @author zhaowei
 * 
 */
public class SystemProduct extends SearchBaseObject {

    private static final long serialVersionUID = 8857750333001427508L;

    /**
     * 产品代码
     */
    private String code;

    /**
     * 
     */
    private String name;

    /**
     * 产品名称
     */
    private String remark;

    /**
     * 排序
     */
    private Integer order_no = 99;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the order_no
     */
    public Integer getOrder_no() {
        return order_no;
    }

    /**
     * @param order_no
     *            the order_no to set
     */
    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemProduct [code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", remark=");
        builder.append(remark);
        builder.append(", order_no=");
        builder.append(order_no);
        builder.append("]");
        return builder.toString();
    }

}
