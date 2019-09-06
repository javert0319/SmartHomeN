package com.hope.smarthome.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.hope.smarthome.R
import com.hope.smarthome.base.BaseActivity
import com.hope.smarthome.constants.ConfigConstants
import com.hope.smarthome.utils.RandomCode
import kotlinx.android.synthetic.main.activity_validation.*

@Route(path = ConfigConstants.VERIFICATION_PATH)
class ValidationActivity : BaseActivity() {

    //产生的验证码
    private var realCode : String ?= null

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_validation)
    }

    override fun initDong() {
        super.initDong()
        //将验证码用图片的形式显示出来
        iv_showCode.setImageBitmap(RandomCode.getInstance().createBitmap())
        realCode = RandomCode.getInstance().code.toLowerCase()
    }

    override fun initEvent() {
        super.initEvent()
        iv_showCode.setOnClickListener {
            iv_showCode.setImageBitmap(RandomCode.getInstance().createBitmap())
            realCode = RandomCode.getInstance().code.toLowerCase()
        }
        but_forgetpass_toSetCodes.setOnClickListener {
            val phoneCode = et_phoneCodes.text.toString().toLowerCase()
            val msg = "生成的验证码："+realCode+"输入的验证码:"+phoneCode
            Log.i("jiawei","ValidationActivity initEvent $msg")
            if (phoneCode == realCode) {
                Toast.makeText(this, phoneCode + "验证码正确", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, phoneCode + "验证码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
