package cn.yumutech.util;

import java.io.Serializable;

/**
 * 
 * 常量类
 * 
 * @author zhaowei
 * 
 */
public class Constants implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8378685138619593510L;
	public final static String PAGE_SEARCH_OBJ = "searvhVO";
	public final static String PAGE_SEARCH_OBJ_OTHER = "searvhVO1";
	public final static String SESSION_USER = "User";
	public final static String SESSION_PORTAL = "Portal";
	public final static String SESSION_PID = "pid";
	public final static String SESSION_FAVOURITE = "Favourite";
	public final static String SESSION_USER_RIGHT = "UserRight";
	public final static String FLAG_UPD = "UPD";
	public final static String OP_TYPE_UPD = "UPD";
	public final static String OP_TYPE_SAVE = "SAVE";
	public final static String OP_TYPE_EDIT = "EDIT";
	public final static String PASSWORD_INIT = "123456";
	public final static String OUT_WRITE_CSV_FILENAME = "out.write.csv.fileName";

	public final static String EXPORT_FILE_SEPRATOR = ",";
	public final static String EXPORT_FILE_TITLE_SEPRATOR = ",";
	public final static int EXPORT_FILE_POLL_LIMIT = 100;
	// 超过5000条就提示
	public final static int EXPORT_FILE_ALERT_LIMIT = 5000;

	public final static String EXPORT_LOG_TITLE = "export.log.title";
	public final static String EXPORT_LOG_COLUMNS = "export.log.columns";

	public final static String CLIENT_APK_DIR = "client_apk.dir";

	public final static String IMAGE_SHARE_DIR = "image_share.dir";

	/**
	 * 根据IP访问获得地理位置信息url
	 */
	public static final String URL1 = "http://api.map.baidu.com/location/ip?ak=uaPxnOC20I9cuspge6f5t06n&ip=";

	/**
	 * 根据经度、纬度获得地理位置信息的url
	 */
	public static final String URL2="http://api.map.baidu.com/geocoder/v2/?ak=uaPxnOC20I9cuspge6f5t06n&output=json&location=";
}
