package cn.yumutech.vo.demo;

import java.io.Serializable;

import cn.yumutech.vo.SearchBaseObject;

/**
 * @author Yetianjiao
 *
 */
public class Equip extends SearchBaseObject implements Serializable{

	private static final long serialVersionUID = 239228797970072482L;
	/*
	 * vo的命名要和数据库中的命名对应，否则在查询语句里面应该用重命名 e_name as name 来决定
	 */

	private Integer id;
	private String e_name;
	private Double  e_price;
	private String e_owner;
	private String is_deleted;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public Double getE_price() {
		return e_price;
	}
	public void setE_price(Double e_price) {
		this.e_price = e_price;
	}
	public String getE_owner() {
		return e_owner;
	}
	public void setE_owner(String e_owner) {
		this.e_owner = e_owner;
	}
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equip [id=");
		builder.append(id);
		builder.append(", e_name=");
		builder.append(e_name);
		builder.append(", e_price=");
		builder.append(e_price);
		builder.append(", e_owner=");
		builder.append(e_owner);
		builder.append(", is_deleted=");
		builder.append(is_deleted);
		builder.append(", getKeyword_condition()=");
		builder.append(getKeyword_condition());
		builder.append("]");
		return builder.toString();
	}
	public Equip() {}
	
	public Equip(Integer id, String e_name, Double e_price, String e_owner, String is_deleted) {
		super();
		this.id = id;
		this.e_name = e_name;
		this.e_price = e_price;
		this.e_owner = e_owner;
		this.is_deleted = is_deleted;
	}
	
	
}
