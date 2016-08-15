/**
 * 
 */
package cn.yumutech.vo.demo;

import cn.yumutech.vo.SearchBaseObject;

/**
 * 学生表
 * 
 * @author zhaowei
 *
 */
public class Student extends SearchBaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780340489601215194L;

	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 学号
	 */
	private String sn;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别，1：男；2：女
	 */
	private Integer gender;
	/**
	 * 性别表示名
	 */
	private String gender_name;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 是否有效，0：有效；1：已删除
	 */
	private Integer is_deleted = 0;
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
	 * @return the sn
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * @param sn the sn to set
	 */
	public void setSn(String sn) {
		this.sn = sn;
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
	 * @return the gender
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the is_deleted
	 */
	public Integer getIs_deleted() {
		return is_deleted;
	}
	/**
	 * @param is_deleted the is_deleted to set
	 */
	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	
	
	/**
	 * @return the gender_name
	 */
	public String  getGender_name() {
		return gender_name;
	}
	/**
	 * @param gender_name the gender_name to set
	 */
	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("Student [id=");
	    builder.append(id);
	    builder.append(", sn=");
	    builder.append(sn);
	    builder.append(", name=");
	    builder.append(name);
	    builder.append(", gender=");
	    builder.append(gender);
	    builder.append(", gender_name=");
	    builder.append(gender_name);
	    builder.append(", age=");
	    builder.append(age);
	    builder.append(", is_deleted=");
	    builder.append(is_deleted);
	    builder.append(", toString()=");
	    builder.append(super.toString());
	    builder.append("]");
	    return builder.toString();
    }
	
	
	
	
	
	
	

}
