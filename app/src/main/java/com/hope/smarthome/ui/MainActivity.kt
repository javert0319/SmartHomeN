package com.hope.smarthome.ui

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.*
import com.hope.smarthome.R
import com.hope.smarthome.base.BaseActivity
import com.hope.smarthome.constants.ConfigConstants
import com.hope.smarthome.interceptor.LoginNavigationCallbackImpl
import com.hope.smarthome.utils.Calendar
import com.hope.smarthome.utils.ChinNumDemo
import com.hope.smarthome.utils.ChineseNumber
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val chineseNumber = ChineseNumber()

    private val calendar = Calendar()

    override fun initVarAndView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        val numberToChinese = chineseNumber.numberToChinese(4294967295L)

        val isLeapYear = calendar.isLeapYear(2012)

        val calculateJulianDay = calendar.calculateJulianDay(2005,5,31,12,0,0.0)

        val week = calendar.weekOfDay(2005,5,31,12,0,0.0)

        val weekZeller = calendar.zellerWeek(2005,5,31)

        LogUtils.i(ConfigConstants.TAG,"MainActivity numberToChinese $numberToChinese")

        LogUtils.i(ConfigConstants.TAG,"MainActivity numberToChinese $isLeapYear")

        LogUtils.i(ConfigConstants.TAG,"MainActivity numberToChinese $calculateJulianDay")

        LogUtils.i(ConfigConstants.TAG,"MainActivity numberToChinese $week")

        LogUtils.i(ConfigConstants.TAG,"MainActivity numberToChinese $weekZeller")
    }

    override fun initEvent() {
        btn_login.setOnClickListener {
            ARouter.getInstance().build(ConfigConstants.LOGIN_PATH)
                .navigation()
        }
        btn_intercept.setOnClickListener {
            ARouter.getInstance().build(ConfigConstants.INTERCEPT_PATH)
                .withString("parameter", "ARouter传递过来的需要登录的参数msg")
                .navigation(this, LoginNavigationCallbackImpl())
        }
        btn_no_intercept.setOnClickListener {
            ARouter.getInstance().build(ConfigConstants.NO_INTERCEPT_PATH)
                .withString("parameter", "ARouter传递过来的不需要登录的参数msg")
                .navigation()
        }
        btn_exit.setOnClickListener {
            ToastUtils.showShort("退出登录成功")
            SPUtils.getInstance().remove(ConfigConstants.SP_IS_LOGIN)
        }
    }
}
