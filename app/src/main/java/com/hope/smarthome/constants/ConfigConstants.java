package com.hope.smarthome.constants;

import com.hope.smarthome.BuildConfig;

/**
 * @ClassName: ConfigConstants
 * @Description: 参数配置文件
 * @Author: CHIA
 * @CreateDate: 2019/8/15 16:12
 */
public final class ConfigConstants {

    public static final boolean IS_DEBUG = BuildConfig.IS_DEBUG;

    public static final String TAG = "jiawei";

    public static final String PATH = "path";

    //存储是否登录的
    public static final String SP_IS_LOGIN = "sp_is_login";

    private static final String BASE_PATH = "/hope/path/";

    //登录
    public static final String LOGIN_PATH = BASE_PATH + "login";
    //不需要登录的activity
    public static final String NO_INTERCEPT_PATH = BASE_PATH + "no_intercept";
    //需要登录的actvity
    public static final String INTERCEPT_PATH = BASE_PATH + "intercept";
    //图片验证码activity
    public static final String VERIFICATION_PATH = BASE_PATH + "verification";
    //侧滑抽屉样式
    public static final String DRAWERLAYOUT_PATH = BASE_PATH + "drawerlayout";
    //Kotlin进阶
    public static final String HIGH_ORDER_PATH = BASE_PATH + "high_order";

}
