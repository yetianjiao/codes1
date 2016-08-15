/**
 * 
 */
package cn.yumutech.vo.demo;

import cn.yumutech.vo.SearchBaseObject;

/**
 * @author zhaowei
 *
 */
public class Demo extends SearchBaseObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2320760089088156621L;
	private Integer id;
	private String name;
	private String remark;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param name the name to set
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
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Demo [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	

}
