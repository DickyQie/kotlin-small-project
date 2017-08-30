package com.zhangqie.login.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhangqie.login.presenter.BasePerenter

/**
 * Created by zhangqie on 2017/6/26.
 */
abstract class BaseActivity<V,T : BasePerenter<V>> : AppCompatActivity(){

    var p: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = createPresenter()
        p!!.attchView(this as V)
    }

    abstract fun createPresenter(): T

    override fun onDestroy() {
        p!!.datchView()
        super.onDestroy()
    }


}