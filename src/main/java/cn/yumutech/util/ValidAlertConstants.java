package cn.yumutech.util;

/**
 * 此类中放的是struts 国际化文件中的 key
 * 
 * @author zhaowei
 */
public class ValidAlertConstants {

    // 用户设置
    //
    public static final String USER_INPUT_WARN_ALERT = "common.input.warn.alert";
    // 保存成功!
    public static final String USER_SAVE_SUCC = "user.save.succ";
    // 没有此用户!
    public static final String USER_UPD_FIND = "user.upd.find";
    // 此用户已经存在!
    public static final String USER_ALREADY_EXIST = "user.already.exist";
    // 重置密码成功
    public static final String USER_RESETPASSWORD_SUCC = "user.resetpassword.succ";
    // 重置密码失败
    public static final String USER_RESETPASSWORD_FAIL = "user.resetpassword.fail";
    public static final String USER_SETFAVOURITE_SUCCES = "user.setfavourite.succes";
    // 登录
    // 请输入用户名和密码!
    public static final String LOGIN_WARN = "login.warn";
    // 输入的用户名与密码错误!
    public static final String LOGIN_ERROR = "login.error";
    // 输入的用户名不存在!
    public static final String LOGIN_NO_SUCH_USER = "login.no.such.user";
    // 用户名或者密码不正确!
    public static final String LOGIN_WRONG_USER_PWD = "login.wrong.user.pwd";
    // 密码变更成功!
    public static final String LOGIN_UPD_PASSWORD_SUCCESS = "login.upd.password.success";
    // 用户没有权限!
    public static final String LOGIN_NO_RIGHT = "login.no.right";
    // 用户无效!
    public static final String LOGIN_NOT_ENABLED = "login.not.enabled";

    // 此字段要在 mybatis mapper.xml中判断 是否为0 "
    // 修改成功!
    public static final String COMMON_UPD_SUCC = "common.upd.succ";
    // 修改失败!
    public static final String COMMON_UPD_FAIL = "common.upd.fail";
    // 保存成功!
    public static final String COMMON_SAVE_SUCC = "common.save.succ";
    // 保存失败!
    public static final String COMMON_SAVE_FAIL = "common.save.fail";
    // 请输入(红色框)必填项!
    public static final String COMMON_INPUT_WARN_ALERT = "common.input.warn.alert";
    // 删除失败!
    public static final String COMMON_DEL_FAIL = "common.del.fail";
    // 删除成功!
    public static final String COMMON_DEL_SUCC = "common.del.succ";
    public static final String COMMON_NULL_FAIL = "common.null.fail";

    public static final int INVALID_MEMORY_NO = 0;
    // 成功时返回json 对象的id=1
    public static final String COMMON_SAVE_SUCC_ID = "1";
    // 成功时返回json 对象的id=0
    public static final String COMMON_SAVE_WARN_ID = "0";
    // 成功时返回json 对象的id=-1
    public static final String COMMON_SAVE_FAIL_ID = "-1";

    // 导出
    // 数据量超过5000条,确定导出吗?
    public static final String OUT_WRITE_CSV_MAX_SIZE = "out.write.csv_max.size";
    // 只有0条数据,确定导出吗?
    public static final String OUT_WRITE_CSV_EMPTY = "out.write.csv.empty";

}
