package com.tikoua.qianjinsan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.qjs.database.flow.FlowDetail
import com.tikoua.qianjinsan.module.flow.FlowManager

class MainActivity : AppCompatActivity() {
    private var flowManager: FlowManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flowManager?.allFlow()?.asLiveData()?.observe(this, object : Observer<List<FlowDetail>> {
            override fun onChanged(t: List<FlowDetail>?) {

            }
        })
    }
}