/**
 * 
 */
package cn.yumutech.vo.platform;

import cn.yumutech.vo.SearchBaseObject;

/**
 * 角色模型
 * 
 * @author zhaowei
 * 
 */
public class Role extends SearchBaseObject {

    private static final long serialVersionUID = -5481981494494364086L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色代码
     */
    private String code;

    /**
     * 是否删除
     */
    private Integer is_delete = 0;

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
     * @return the is_delete
     */
    public Integer getIs_delete() {
        return is_delete;
    }

    /**
     * @param is_delete
     *            the is_delete to set
     */
    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Role [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", code=");
        builder.append(code);
        builder.append(", is_delete=");
        builder.append(is_delete);
        builder.append("]");
        return builder.toString();
    }

}
