package cn.yumutech.util;

import java.io.Serializable;

/**
 * web常量类
 * 
 * @author zhaowei
 * 
 */
public class WebConstants implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -6814370083904903581L;

    /**
     * 唯一性消息
     */
    public static final String UNIQUE_MESSAGE = "uniqueMessage";

    /**
     * 备注头
     */
    public static final String REMARK_TITLE = "remark";

    /**
     * 每页显示的行数
     */
    public final static Integer PAGE_SIZE = 20;

    /**
     * 每页显示的行数
     */
    public final static int PAGING_SIZE = 20;
    /**
     * 每页最小行数
     */
    public final static int PAGING_SIZE_LOW = 5;

    public static final String IMAGE_SAVE_BASE_DIR = "image.save.base.dir";

    public static final String WAREHOUSE_SAVE_BASE_DIR = "warehouse.save.base.dir";

}
