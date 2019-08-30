package com.hope.smarthome.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.hope.smarthome.R
import com.hope.smarthome.base.BaseActivity
import com.hope.smarthome.constants.ConfigConstants
import kotlinx.android.synthetic.main.activity_no_intercept.*

@Route(path = ConfigConstants.NO_INTERCEPT_PATH)
class NoInterceptActivity : BaseActivity() {

    @Autowired
    @JvmField
    var parameter: String? = null

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_no_intercept)

        tv_no_intercept.text = parameter
    }
}
