package com.hope.smarthome.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.hope.smarthome.R
import com.hope.smarthome.base.BaseActivity
import com.hope.smarthome.constants.ConfigConstants
import kotlinx.android.synthetic.main.activity_intercept.*

@Route(path = ConfigConstants.INTERCEPT_PATH)
class InterceptActivity : BaseActivity() {

    @Autowired
    @JvmField
    var parameter: String? = null

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_intercept)

        tv_intercept.text = parameter
    }
}
