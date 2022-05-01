package com.zp.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptUtil {

    private static BasicTextEncryptor basicTextEncryptor;

    static {
        //初始化
        basicTextEncryptor = new BasicTextEncryptor();
        //密匙
        basicTextEncryptor.setPassword("zzj_cdy_ssj_pzz");
    }
    public static String jia(String password){
        //加密密码
        String Spassword = basicTextEncryptor.encrypt(password);
        return Spassword;
    }
    public static String jie(String Spassword){
        //加密密码
        String password = basicTextEncryptor.decrypt(Spassword);
        return password;
    }
}
