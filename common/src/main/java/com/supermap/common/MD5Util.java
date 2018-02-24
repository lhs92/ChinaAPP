package com.supermap.common;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:langhongshuai
 * @Description:MD5加密工具类
 * @Date:18/1/4 下午5:37
 */
public class MD5Util {
    /**
     * 通过MD5的方式给字符串加密
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String EncoderByMd5(String str)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
            //确定计算方法
            MessageDigest md5= MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr=new BigInteger(1, md5.digest(str.getBytes("utf-8"))).toString(16);
            return newstr;
            }
}
