package com.hope.smarthome.interceptor;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.hope.smarthome.constants.ConfigConstants;

/**
 * @ClassName: LoginInterceptorImpl
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/8/15 16:27
 */
@Interceptor(name = "login", priority = 6)
public class LoginInterceptorImpl implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        LogUtils.i(ConfigConstants.TAG,path);
        boolean isLogin = SPUtils.getInstance().getBoolean(ConfigConstants.SP_IS_LOGIN, false);
        if (isLogin) { // 如果已经登录不拦截
            callback.onContinue(postcard);
        } else {  // 如果没有登录
            switch (path) {
                // 需要登录的直接拦截下来（将需要登录的路径添加进来）
                case ConfigConstants.INTERCEPT_PATH:
                    callback.onInterrupt(null);
                    break;
                // 登录过的直接进入这个页面
                case ConfigConstants.LOGIN_PATH:
                    callback.onContinue(postcard);
                    break;
                default:
                    callback.onContinue(postcard);
                    // 不需要登录的直接进入这个页面
                    break;
            }
        }
    }

    @Override
    public void init(Context context) {
        LogUtils.i("路由登录拦截器初始化成功"); //只会走一次
    }
}
