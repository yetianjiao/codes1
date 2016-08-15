/**
 * 
 */
package cn.yumutech.vo.platform;

import cn.yumutech.vo.SearchBaseObject;

/**
 * 系统分类模型
 * 
 * @author zhaowei
 * 
 */
public class SystemField extends SearchBaseObject {

    private static final long serialVersionUID = 4726861789094172314L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 所属产品id
     */
    private String system_product_code;

    /**
     * 所属产品
     */
    private String system_product_name;

    /**
     * 分类代码
     */
    private String code;

    /**
     * 分类名
     */
    private String name;

    /**
     * 排序
     */
    private Integer order_no = 999;

    /**
     * 是否允许编辑，默认为1，可以编辑；0为不可以编辑
     */
    private Integer allow_edit_option = 1;

    /**
     * 备注
     */
    private String remark;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the system_product_code
     */
    public String getSystem_product_code() {
        return system_product_code;
    }

    /**
     * @param system_product_code
     *            the system_product_code to set
     */
    public void setSystem_product_code(String system_product_code) {
        this.system_product_code = system_product_code;
    }

    /**
     * @return the system_product_name
     */
    public String getSystem_product_name() {
        return system_product_name;
    }

    /**
     * @param system_product_name
     *            the system_product_name to set
     */
    public void setSystem_product_name(String system_product_name) {
        this.system_product_name = system_product_name;
    }

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

    /**
     * @return the allow_edit_option
     */
    public Integer getAllow_edit_option() {
        return allow_edit_option;
    }

    /**
     * @param allow_edit_option
     *            the allow_edit_option to set
     */
    public void setAllow_edit_option(Integer allow_edit_option) {
        this.allow_edit_option = allow_edit_option;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemField [id=");
        builder.append(id);
        builder.append(", system_product_code=");
        builder.append(system_product_code);
        builder.append(", system_product_name=");
        builder.append(system_product_name);
        builder.append(", code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", order_no=");
        builder.append(order_no);
        builder.append(", allow_edit_option=");
        builder.append(allow_edit_option);
        builder.append(", remark=");
        builder.append(remark);
        builder.append("]");
        return builder.toString();
    }

}
