package com.hope.smarthome.interceptor;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.hope.smarthome.constants.ConfigConstants;

/**
 * @ClassName: LoginNavigationCallbackImpl
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/8/15 16:42
 */
public class LoginNavigationCallbackImpl implements NavigationCallback {
    @Override //找到了
    public void onFound(Postcard postcard) {

    }

    @Override //找不到了
    public void onLost(Postcard postcard) {

    }

    @Override    //跳转成功了
    public void onArrival(Postcard postcard) {

    }

    @Override
    public void onInterrupt(Postcard postcard) {
        String path = postcard.getPath();
        LogUtils.i(ConfigConstants.TAG,path);
        Bundle bundle = postcard.getExtras();
        // 拦截了
        ARouter.getInstance().build(ConfigConstants.LOGIN_PATH)
                .with(bundle)
                .withString(ConfigConstants.PATH, path)
                .navigation();
    }
}
