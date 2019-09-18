package com.hope.smarthome.kotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.hope.smarthome.R
import com.hope.smarthome.constants.ConfigConstants
import com.hope.smarthome.kotlin.adapter.OrderAdapter
import com.hope.smarthome.kotlin.bean.Order
import kotlinx.android.synthetic.main.activity_high_order.*
import java.util.*

@Route(path = ConfigConstants.HIGH_ORDER_PATH)
class HighOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_order)

        initAdapter()
    }

    private fun initAdapter() {
        val orderAdapter = OrderAdapter(R.layout.order_item_view,getItemData())
        orderAdapter.openLoadAnimation()
        val top = layoutInflater.inflate(R.layout.order_top_view,rv_high_order.parent as ViewGroup,false)
        val foot = layoutInflater.inflate(R.layout.order_foot_view,rv_high_order.parent as ViewGroup,false)
        orderAdapter.addHeaderView(top)
        orderAdapter.addFooterView(foot)
        orderAdapter.setOnItemClickListener { adapter, view, position ->
            val item = adapter.getItem(position) as Order
            Log.i("jiawei","title " + item.title +" icon " + item.imgUrl)
        }
        rv_high_order.layoutManager = GridLayoutManager(this,2)
        rv_high_order.adapter = orderAdapter
    }

    private fun getItemData(): List<Order>? {
        return Arrays.asList(
            Order("Android",R.mipmap.music_local_ic_songlist_default),
            Order("Java",R.mipmap.music_local_ic_songlist_default),
            Order("IOS",R.mipmap.music_local_ic_songlist_default),
            Order("C++",R.mipmap.music_local_ic_songlist_default),
            Order("Python",R.mipmap.music_local_ic_songlist_default),
            Order("Visual Basic",R.mipmap.music_local_ic_songlist_default),
            Order("PHP",R.mipmap.music_local_ic_songlist_default),
            Order("JavaScript",R.mipmap.music_local_ic_songlist_default),
            Order("SQL",R.mipmap.music_local_ic_songlist_default),
            Order("HTML",R.mipmap.music_local_ic_songlist_default),
            Order("Swift",R.mipmap.music_local_ic_songlist_default),
            Order("OC",R.mipmap.music_local_ic_songlist_default),
            Order("GO",R.mipmap.music_local_ic_songlist_default)
        )
    }
}
