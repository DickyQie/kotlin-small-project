package com.zhangqie.login.presenter

import java.lang.ref.WeakReference

/**
 * Created by zhangqie on 2017/6/26.
 */
open class BasePerenter<T> {

    var weakReference: WeakReference<T>? = null

    fun attchView(t: T){
        weakReference = WeakReference<T>(t)
    }

    fun datchView(){
        if (weakReference != null){
            weakReference!!.clear()
            weakReference = null
        }
    }

    fun getView() : T?{
        if (weakReference != null){
            return weakReference!!.get()
        }else{
            return null
        }
    }

}