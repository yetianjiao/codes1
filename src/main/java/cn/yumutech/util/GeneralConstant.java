package cn.yumutech.util;

/**
 * 通用常量类
 * 
 * @author zhaowei
 * 
 */
public class GeneralConstant {

    /**
     * 行数常量
     */
    public static final String ROW_COUNT = "ROW_COUNT";
    /**
     * 泪飙值常量
     */
    public static final String VALUE_LIST = "VALUE_LIST";

    /**
     * 唯一性消息
     */
    public static final String UNIQUE_MESSAGE = "uniqueMessage";
    
    public static final String REMARK_TITLE="remark";

    /**
     * 每页显示的行数
     */
    public final static Integer PAGE_SIZE = 20;

    /**
     * 每页最小行数
     */
    //public final static int PAGING_SIZE_LOW = 5;

    public static final String IMAGE_SAVE_BASE_DIR = "image.save.base.dir";

    /**
     * ==========================数据字典用开始===========================
     * 
     */
    /**
     * 全局
     */
    public static final String SYSTEM_PRODUCT_GLOBAL = "global";

    /***
     * 用户状态
     */
    public static final String SYSTEM_FIELD_USER_STATE = "user_state";

    /**
     * 审计状态
     */
    public static final String SYSTEM_FIELD_AUDIT_STATE = "audit_state";

    /**
     * 有效性
     */
    public static final String SYSTEM_FIELD_ENABLE = "enable";

    /**
     * 性别
     */
    public static final String SYSTEM_FIELD_GENDER = "gender";

    /**
     * 报销类型
     */
    public static final String SYSTEM_FIELD_APPLY_TYPE = "apply_type";
    /**
     * 报销状态
     */
    public static final String SYSTEM_FIELD_APPLY_STATE = "apply_state";

    /**
     * 报销项目分类
     */
    public static final String SYSTEM_FIELD_APPLY_CLASSIFY = "apply_classify";

    /**
     * ==========================数据字典用结束===========================
     * 
     */
    /**
     * ==========================MESSAGE===========================
     * 
     */

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
    // 数据量超过5000条,确定导出吗?
    public static final String OUT_WRITE_CSV_MAX_SIZE = "out.write.csv_max.size";
    // 只有0条数据,确定导出吗?
    public static final String OUT_WRITE_CSV_EMPTY = "out.write.csv.empty";
    public final static String OUT_WRITE_CSV_FILENAME = "out.write.csv.fileName";
    public final static String IMAGE_SHARE_DIR = "image_share.dir";

    /**
     * ==========================MESSAGE===========================
     * 
     */

    public static final int INVALID_MEMORY_NO = 0;
    // 成功时返回json 对象的id=1
    public static final String COMMON_SAVE_SUCC_ID = "1";
    // 成功时返回json 对象的id=0
    public static final String COMMON_SAVE_WARN_ID = "0";
    // 成功时返回json 对象的id=-1
    public static final String COMMON_SAVE_FAIL_ID = "-1";

    // 导出
    public final static String EXPORT_FILE_SEPRATOR = ",";
    public final static String EXPORT_FILE_TITLE_SEPRATOR = ",";
    public final static int EXPORT_FILE_POLL_LIMIT = 100;
    // 超过5000条就提示
    public final static int EXPORT_FILE_ALERT_LIMIT = 5000;

    public final static String PAGE_SEARCH_OBJ = "searvhVO";
    public final static String PAGE_SEARCH_OBJ_OTHER = "searvhVO1";
    public final static String SESSION_USER = "User";
    public final static String SESSION_USER_RIGHT = "UserRight";
    public final static String PASSWORD_INIT = "password.init";

}
