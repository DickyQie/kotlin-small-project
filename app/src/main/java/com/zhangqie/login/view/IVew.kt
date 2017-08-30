package com.zhangqie.login.view

/**
 * Created by zhangqie on 2017/6/26.
 */
interface IVew {

    fun showLoading(msg: String)

    fun onNetWork(net: String)

    fun onError(error: String)

}