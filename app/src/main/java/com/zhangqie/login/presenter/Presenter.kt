package com.zhangqie.login.presenter

import com.zhangqie.login.model.IModel
import com.zhangqie.login.model.ModelImple
import com.zhangqie.login.view.IVew

/**
 * Created by zhangqie on 2017/6/26.
 */
class Presenter : BasePerenter<IVew>(){

    var Imodel: IModel? = null
    init {
        Imodel = ModelImple()
    }

    fun onLogin(name: String,pwd: String){
        var iView = getView()
        /*if (false){
            //验证网络
            if (iView != null) {
                iView.onNetWork("网络未连接")
            }
        }*/

        Imodel!!.onLogin(name,pwd,object : IModel.IOnLoginSetListenter{

            override fun onSuccess(success: String) {
                if (iView != null){
                    iView.showLoading(success)
                }
            }

            override fun onError(error: String) {
                if (iView != null){
                    iView.onError(error)
                }
            }
        })

    }

}