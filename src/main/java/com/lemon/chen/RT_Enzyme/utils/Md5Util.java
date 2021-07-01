package com.lemon.chen.RT_Enzyme.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * MD5加密
 * @author Ji Rui
 * @date 2020/6/28
 */

public class Md5Util {

    /** 加盐 */
    private final static String SALT = "8ba65fce-d26f-41b9-b1b6-542b6f1482a8";

    /**
     * 生成md5
     * @param str 要加密的字符串
     * @return 加密结果
     */
    public static String stringToMd5(String str) {
        String base = SALT + str + SALT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    private static final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

}
