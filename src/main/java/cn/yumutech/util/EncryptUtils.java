package cn.yumutech.util;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * 
 * @author zhaowei
 * 
 */
public class EncryptUtils implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 2927033026790325284L;

    /**
     * MD2加密算法
     * 
     * @param plantText
     *            需要加密的字符串
     * @return String型 加密后的字符串
     */
    public static String getMD2EncString(String plantText) {
        return getEncString(plantText, "MD2");
    }

    /**
     * MD5加密算法
     * 
     * @param plantText
     *            需要加密的字符串
     * @return String型 加密后的字符串
     */
    public static String getMD5EncString(String plantText) {
        return getEncString(plantText, "MD5");
    }

    /**
     * SHA-1加密算法
     * 
     * @param plantText
     *            需要加密的字符串
     * @return String型 加密后的字符串
     */
    public static String getSHA1EncString(String plantText) {
        return getEncString(plantText, "SHA-1");
    }

    /**
     * SHA-256加密算法
     * 
     * @param plantText
     *            需要加密的字符串
     * @return String型 加密后的字符串
     */
    public static String getSHA256EncString(String plantText) {
        return getEncString(plantText, "SHA-256");
    }

    /**
     * SHA-384加密算法
     * 
     * @param plantText
     *            需要加密的字符串
     * @return String型 加密后的字符串
     */
    public static String getSHA384EncString(String plantText) {
        return getEncString(plantText, "SHA-384");
    }

    /**
     * SHA-512加密算法
     * 
     * @param plantText
     *            需要加密的字符串
     * @return String型 加密后的字符串
     */
    public static String getSHA512EncString(String plantText) {
        return getEncString(plantText, "SHA-512");
    }

    /**
     * 数据加密算法
     * 
     * @param plainText
     *            加密字符串
     * @param algorithm
     *            加密算法，支持SHA-1,SHA-2(SHA-256,SHA-384,SHA-512),MD2,MD5
     * @return 加密结果
     */
    private static String getEncString(String plainText, String algorithm) {

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(plainText.getBytes());
            byte[] b = md.digest();
            StringBuilder output = new StringBuilder(32);
            for (int i = 0; i < b.length; i++) {
                String temp = Integer.toHexString(b[i] & 0xff);
                if (temp.length() < 2) {
                    output.append("0");// 不足两位，补0
                }
                output.append(temp);
            }
            return output.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String getSHA1EncString = getSHA1EncString("zhaowei");
        System.out.println(getSHA1EncString);
        // 8198a0236574e9fadb6e1299744fdefd0e212759
    }
}
