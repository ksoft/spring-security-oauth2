package com.ksoft.constant;

import java.io.File;

/**
 * Created by 李朝衡 on 2017/3/13.
 * 常量
 */
public class ServerConstant {
    /**
     * auth key
     */
    public static final String REQ_HEADER_AUTH_KEY = "Token";
    /**
     * auth user key
     */
    public static final String REQ_HEADER_API_KEY = "api-user";
    public static final int MAX_FRONT_PICS_SIZE = 1;
    public static final int MAX_TYRE_PICS_SIZE = 6;
    public static final int MAX_SCENE_PICS_SIZE = 1;
    public static final char SEPERATOR_FILE = File.separatorChar;
    /**
     * 数据库图片保存的分隔符
     */
    public static final String SEPARATOR_PICS = "@#@";

    public static final String SESSION_KEY_KAPTCHA = "RESCUE_KAPTCHA_CODE";
    private ServerConstant(){

    }
}
