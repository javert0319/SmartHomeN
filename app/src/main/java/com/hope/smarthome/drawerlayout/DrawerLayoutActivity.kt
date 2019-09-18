package com.hope.smarthome.drawerlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import com.alibaba.android.arouter.facade.annotation.Route
import com.hope.smarthome.R
import com.hope.smarthome.constants.ConfigConstants
import kotlinx.android.synthetic.main.activity_drawer_layout.*

@Route(path = ConfigConstants.DRAWERLAYOUT_PATH)
class DrawerLayoutActivity : AppCompatActivity() {

    private var mToggle:ActionBarDrawerToggle ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_layout)
        //设置Toolbar
        setToolbar()
        //设置DrawerToggle 开关
        setDrawerToggle()
        //设置监听器
        setListener()
    }

    private fun setListener() {
        navigation_view.itemIconTintList = null
        navigation_view.setNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun setDrawerToggle() {
        mToggle = ActionBarDrawerToggle(this,drawer_layout,toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(mToggle!!)
        mToggle?.syncState()
    }

    private fun setToolbar() {
        toolbar.title = getString(R.string.home)
        setSupportActionBar(toolbar)
        // 显示Home的图标
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private var onNavigationItemSelectedListener: NavigationView.OnNavigationItemSelectedListener =
        NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_favorite_article -> {
                    tv_drawer.text = getString(R.string.favorite_article)
                }
                R.id.menu_about -> {
                    tv_drawer.text = getString(R.string.about_us)
                }
                R.id.menu_exit -> {
                    tv_drawer.text = getString(R.string.exit)
                }
                R.id.menu_home -> {
                    tv_drawer.text = getString(R.string.home)
                }
                else -> {
                }
            }
            //关闭侧边栏
            drawer_layout.closeDrawers()
            true
        }
}
