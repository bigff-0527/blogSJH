package com.bigff.blog.po.util;
import org.springframework.util.DigestUtils;

public class MD5utils {

    //盐，用于混交md5
//    private static String salt = "asdwqAsd12_qS";

    /**
     * 生成md5
     * @param str
     * @return
     */
    public static String getMD5(String str) {

        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5;
    }

    public static void main(String[] args) {
        System.out.println(getMD5("111111"));
    }

}