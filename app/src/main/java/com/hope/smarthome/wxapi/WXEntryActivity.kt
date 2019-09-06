package com.hope.smarthome.wxapi

import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.hope.smarthome.R

class WXEntryActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wxentry)

        var intent = Intent()
        intent.component = ComponentName.createRelative("","")
        intent.putExtra("devId","12346")
        startActivityForResult(intent,0)
    }
}
