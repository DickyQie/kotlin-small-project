package com.zhangqie.login.model

/**
 * Created by zhangqie on 2017/6/26.
 */
interface IModel {

    fun onLogin(name: String,pwd: String,onLoginSetListenter: IOnLoginSetListenter)

    interface IOnLoginSetListenter {

        fun onError(error: String)

        fun onSuccess(success: String)
    }

}