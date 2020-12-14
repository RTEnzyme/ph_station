package com.lemon.admin.cofjus.utils;

import org.springframework.util.DigestUtils;

/**
 * MD5加密
 * @author Ji Rui
 * @date 2020/6/28
 */

public class Md5Util {

    /** 加盐 */
    private final static String SALT = "578ca82ec19d9a635d93f799d0bd23bc";

    /**
     * 生成md5
     * @param str 要加密的字符串
     * @return 加密结果
     */
    public static String stringToMd5(String str) {
        String base = SALT + str + SALT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
