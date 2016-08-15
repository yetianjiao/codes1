/**
 * 
 */
package cn.yumutech.vo.platform;

import java.util.Date;

import cn.yumutech.vo.SearchBaseObject;

/**
 * 用户模型
 * 
 * @author zhaowei
 * 
 */
public class User extends SearchBaseObject {

    private static final long serialVersionUID = 4775086271765849042L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 登录帐号
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 新密码
     */
    private String password_new;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别：1 男 2女
     */
    private Integer gender;

    /**
     * 性别表示名
     */
    private String gender_name;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 电话
     */
    private String telephone;

    /**
     * QQ
     */
    private String qq;

    /**
     * 住所
     */
    private String address;

    /**
     * 邮编
     */
    private String post_code;

    /**
     * 所属角色id
     */
    private Integer role_id;

    /**
     * 所属角色名
     */
    private String role_name;

    /**
     * 状态 -1：未激活，1：激活
     */
    private Integer user_state = -1;

    /**
     * 状态显示名
     */
    private String user_state_name;

    /**
     * 是否删除 0：未删除，1：删除
     */
    private Integer is_delete = 0;


    
    private String user_type;
    
    private String user_type_name;
    
    private String logo_path;
    
    private String label_display_name;
    
    
    

    /**
     * @return the label_display_name
     */
    public String getLabel_display_name() {
        return label_display_name;
    }

    /**
     * @param label_display_name the label_display_name to set
     */
    public void setLabel_display_name(String label_display_name) {
        this.label_display_name = label_display_name;
    }

    /**
     * @return the logo_path
     */
    public String getLogo_path() {
        return logo_path;
    }

    /**
     * @param logo_path the logo_path to set
     */
    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

   

  

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     *            the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * @return the gender_name
     */
    public String getGender_name() {
        return gender_name;
    }

    /**
     * @param gender_name
     *            the gender_name to set
     */
    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     *            the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     *            the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the post_code
     */
    public String getPost_code() {
        return post_code;
    }

    /**
     * @param post_code
     *            the post_code to set
     */
    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    /**
     * @return the role_id
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * @param role_id
     *            the role_id to set
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * @return the role_name
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * @param role_name
     *            the role_name to set
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
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

    /**
     * @return the password_new
     */
    public String getPassword_new() {
        return password_new;
    }

    /**
     * @param password_new
     *            the password_new to set
     */
    public void setPassword_new(String password_new) {
        this.password_new = password_new;
    }

    /**
     * @return the user_state
     */
    public Integer getUser_state() {
        return user_state;
    }

    /**
     * @param user_state the user_state to set
     */
    public void setUser_state(Integer user_state) {
        this.user_state = user_state;
    }

    /**
     * @return the user_state_name
     */
    public String getUser_state_name() {
        return user_state_name;
    }

    /**
     * @param user_state_name the user_state_name to set
     */
    public void setUser_state_name(String user_state_name) {
        this.user_state_name = user_state_name;
    }

    /**
     * @return the user_type
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * @param user_type the user_type to set
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    /**
     * @return the user_type_name
     */
    public String getUser_type_name() {
        return user_type_name;
    }

    /**
     * @param user_type_name the user_type_name to set
     */
    public void setUser_type_name(String user_type_name) {
        this.user_type_name = user_type_name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", password_new=");
        builder.append(password_new);
        builder.append(", nickname=");
        builder.append(nickname);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", gender_name=");
        builder.append(gender_name);
        builder.append(", birthday=");
        builder.append(birthday);
        builder.append(", email=");
        builder.append(email);
        builder.append(", mobile=");
        builder.append(mobile);
        builder.append(", telephone=");
        builder.append(telephone);
        builder.append(", qq=");
        builder.append(qq);
        builder.append(", address=");
        builder.append(address);
        builder.append(", post_code=");
        builder.append(post_code);
        builder.append(", role_id=");
        builder.append(role_id);
        builder.append(", role_name=");
        builder.append(role_name);
        builder.append(", user_state=");
        builder.append(user_state);
        builder.append(", user_state_name=");
        builder.append(user_state_name);
        builder.append(", is_delete=");
        builder.append(is_delete);
        builder.append(", user_type=");
        builder.append(user_type);
        builder.append(", user_type_name=");
        builder.append(user_type_name);
        builder.append(", logo_path=");
        builder.append(logo_path);
        builder.append(", label_display_name=");
        builder.append(label_display_name);
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }

 

}
