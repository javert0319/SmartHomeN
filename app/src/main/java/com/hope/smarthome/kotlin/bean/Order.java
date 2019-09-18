package com.hope.smarthome.kotlin.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @ClassName: Order
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/9/17 16:59
 */
public class Order implements MultiItemEntity {
    private String title;
    private int imgUrl;

    public Order(){}

    public Order(String title,int imgUrl){
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
