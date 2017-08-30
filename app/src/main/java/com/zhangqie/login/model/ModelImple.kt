package com.zhangqie.login.model

/**
 * Created by zhangqie on 2017/6/26.
 */
class ModelImple : IModel{

    override fun onLogin(name: String, pwd: String,onLoginSetListenter: IModel.IOnLoginSetListenter) {
        if (name.isEmpty()) {
            if (onLoginSetListenter != null) {
                onLoginSetListenter.onError("输入用户名为空")
                return
            }
        }
        if (pwd.isEmpty()) {
            if (onLoginSetListenter != null) {
                onLoginSetListenter.onError("输入密码为空")
                return
            }
        }
        if (name.equals("zq") && pwd.equals("123456")){
            if (onLoginSetListenter != null)
                onLoginSetListenter.onSuccess("登录成功")
        }else{
            if (onLoginSetListenter != null) {
                onLoginSetListenter.onError("登录失败")
            }
        }
    }
}