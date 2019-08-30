package com.hope.smarthome.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.StringUtils
import com.blankj.utilcode.util.ToastUtils
import com.hope.smarthome.R
import com.hope.smarthome.base.BaseActivity
import com.hope.smarthome.constants.ConfigConstants
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = ConfigConstants.LOGIN_PATH)
class LoginActivity : BaseActivity(){

    @Autowired
    @JvmField
    var path: String? = null

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_login)
        LogUtils.i(ConfigConstants.TAG,"LoginActivity onCreate $path")
    }

    override fun initEvent() {
        super.initEvent()
        LogUtils.i(ConfigConstants.TAG,"LoginActivity initDong $path")

        btn_login_activity.setOnClickListener {
            SPUtils.getInstance().put(ConfigConstants.SP_IS_LOGIN, true)

            ToastUtils.showShort("登录成功")
            if (!StringUtils.isEmpty(path)) {
                ARouter.getInstance().build(path)
                    .with(intent.extras)
                    .navigation()
            }
            finish()
        }
    }

}
