package cn.yumutech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件工具类
 * 
 * @author zhaowei
 * 
 */
public class FileUtil {

    public static String getFileExtension(String file_name) {
        if (file_name.lastIndexOf(".") != -1 && file_name.lastIndexOf(".") != 0) {
            return file_name.substring(file_name.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static String readFileByBytes(String fileName) {
        InputStream in = null;

        String result = "";

        try {

            // check file exist
            File file = new File(fileName);

            if (file.isFile() && file.exists()) {

                // 一次读多个字节
                byte[] tempbytes = new byte[100];
                @SuppressWarnings("unused")
                int byteread = 0;
                in = new FileInputStream(file);

                // 读入多个字节到字节数组中，byteread为一次读入的字节数
                while ((byteread = in.read(tempbytes)) != -1) {
                    // System.out.write(tempbytes, 0, byteread);
                    result += new String(tempbytes);
                }
                System.out.println(result);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
        return result;
    }

}
