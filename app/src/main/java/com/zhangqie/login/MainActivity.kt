package com.zhangqie.login

import android.os.Bundle
import com.zhangqie.login.base.BaseActivity
import com.zhangqie.login.presenter.Presenter
import com.zhangqie.login.view.IVew
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity<IVew,Presenter>(),IVew{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            p!!.onLogin(username.text.toString(),password.text.toString())
        }
    }

    override fun createPresenter(): Presenter {
        return Presenter()
    }

    override fun showLoading(msg: String) {
        toast(msg)
    }

    override fun onNetWork(net: String) {
        toast(net)
    }

    override fun onError(error: String) {
        toast(error)
    }

}
