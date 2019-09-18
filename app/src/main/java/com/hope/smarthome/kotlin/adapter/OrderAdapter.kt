package com.hope.smarthome.kotlin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.hope.smarthome.R
import com.hope.smarthome.kotlin.bean.Order
import kotlinx.android.synthetic.main.order_item_view.view.*

/**
 * @ClassName: OrderAdapter
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/9/17 17:47
 */
class OrderAdapter(layoutResId: Int, data: List<Order>?) : BaseQuickAdapter<Order, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: Order) {
        helper.setText(R.id.tv_order_title,item.title)
        helper.setImageResource(R.id.iv_order_icon,item.imgUrl)
    }
}
