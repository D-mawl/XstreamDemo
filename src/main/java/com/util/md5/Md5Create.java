package com.util.md5;

import java.security.MessageDigest;
import java.util.Date;

/**
 * <p> 创建时间： 17-5-16</p>
 * <p> 描述： </p>
 *
 * @author : mawl
 * @version 1.0
 */
public class Md5Create {
    private static String relatePath = "/1/2017/05/15/26afb9b2-926e-4cf5-8a00-d7da94750924.jpg";


    private static String tocken = "ivaneve123456";
    private static Long time = new Date().getTime() / 1000 + 50;
    private static MessageDigest md5 = null;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用于获取一个String的md5值
     *
     * @return
     */
    public static String getMd5(String str) {
        byte[] bs = md5.digest(str.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for (byte x : bs) {
            if ((x & 0xff) >> 4 == 0) {
                sb.append("0").append(Integer.toHexString(x & 0xff));
            } else {
                sb.append(Integer.toHexString(x & 0xff));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String orgString = tocken.concat("&").concat(time.toString()).concat("&").concat(relatePath);
        String md5 = getMd5(orgString);
        System.out.println(md5);
        String cnd = md5.substring(md5.length() / 2 - 4, md5.length() / 2 + 4);
        System.out.println(cnd);
        System.out.println(cnd.concat(time.toString()));
    }
}
