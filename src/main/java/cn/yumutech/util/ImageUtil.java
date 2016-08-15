package cn.yumutech.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * 图形工具类
 * 
 * @author zhaowei
 * 
 */
public class ImageUtil implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -2861113054249135973L;

    /**
     * 图片编码
     * 
     * @param imagePath
     *            d:/111.png
     * @param imageFormat
     *            jpg,png,jpeg
     * @return
     */
    public static String encodeImage(String imagePath, String imageFormat) {
        File f = new File(imagePath);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, imageFormat, baos);
            byte[] bytes = baos.toByteArray();

            return new sun.misc.BASE64Encoder().encodeBuffer(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 图片解码
     * 
     * @param binary
     *            BASE64加密图片的二进制字符串
     * @param savePath
     *            图片的保存位置， d:/ss.png
     */
    public void decodeImage(String binary, String savePath) {
        try {

            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

            byte[] bytes = decoder.decodeBuffer(binary);

            File file = new File(savePath);

            FileOutputStream fos = new FileOutputStream(file);

            fos.write(bytes);

            fos.flush();

            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
