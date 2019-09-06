package com.hope.smarthome.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.hope.smarthome.utils.CustomDensity
import com.hope.smarthome.utils.DensityUtils

/**
 * @ClassName:   BaseActivity
 * @Description: Activity基类
 * @Author:      CHIA
 * @CreateDate:  2019/8/15 16:16
 */
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        CustomDensity.setCustomDensity(this,application) //今日头条适配方案
        DensityUtils.match(this,360.0f)
        initVarAndView(savedInstanceState)
        initEvent()
        initDong()
    }

    //初始化变量和界面
    abstract fun initVarAndView(savedInstanceState: Bundle?)
    //初始化事件
    open fun initEvent(){}
    //开始执行
    open fun initDong() {}

}