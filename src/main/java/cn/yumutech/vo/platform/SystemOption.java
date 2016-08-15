/**
 * 
 */
package cn.yumutech.vo.platform;

import cn.yumutech.vo.SearchBaseObject;

/**
 * 系统选项模型
 * 
 * @author zhaowei
 * 
 */
public class SystemOption extends SearchBaseObject {

    private static final long serialVersionUID = -8251093867819040505L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 所属系统分类id
     */
    private Integer system_field_id;

    /**
     * 所属系统分类
     */
    private String system_field_name;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer order_no = 999;

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
     * @return the system_field_id
     */
    public Integer getSystem_field_id() {
        return system_field_id;
    }

    /**
     * @param system_field_id
     *            the system_field_id to set
     */
    public void setSystem_field_id(Integer system_field_id) {
        this.system_field_id = system_field_id;
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
     * @return the system_field_name
     */
    public String getSystem_field_name() {
        return system_field_name;
    }

    /**
     * @param system_field_name
     *            the system_field_name to set
     */
    public void setSystem_field_name(String system_field_name) {
        this.system_field_name = system_field_name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemOption [id=");
        builder.append(id);
        builder.append(", system_field_id=");
        builder.append(system_field_id);
        builder.append(", system_field_name=");
        builder.append(system_field_name);
        builder.append(", code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", order_no=");
        builder.append(order_no);
        builder.append(", remark=");
        builder.append(remark);
        builder.append("]");
        return builder.toString();
    }

}
