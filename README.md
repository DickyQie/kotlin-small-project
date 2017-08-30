# kotlin for android----------MVP模式实现登录 
 <p style="text-align:start">学习了Kotlin，随便来个小案例，以MVP+Kotlin 来实现登录的一个小案例，希望对大家有所帮助，效果图：</p> 
<p style="text-align:start">&nbsp; 　　<img alt="" src="http://images2017.cnblogs.com/blog/1041439/201708/1041439-20170829160437327-1111400533.png"></p> 
<p style="text-align:start">MVP：</p> 
<span id="OSC_h3_1"></span>
<h3><span style="color:#008080">Model</span></h3> 
<p style="text-align:start"><span style="color:#212121">Model 是用户界面需要显示数据的抽象，也可以理解为从业务数据（结果）那里到用户界面的抽象。</span></p> 
<span id="OSC_h3_2"></span>
<h3><strong><span style="color:#008080">View</span></strong></h3> 
<p style="text-align:start"><span style="color:#212121">视图这一层体现的很轻薄，负责显示数据、提供友好界面跟用户交互就行。MVP下Activity和Fragment体现在了这一层，Activity一般也就做加载UI视图、设置监听再交由Presenter处理的一些工作，所以也就需要持有相应Presenter的引用。</span></p> 
<span id="OSC_h3_3"></span>
<h3><strong><span style="color:#008080">Presenter</span></strong></h3> 
<p><span style="color:#212121">Presenter这一层处理着程序各种逻辑的分发，收到View层UI上的反馈命令、定时命令、系统命令等指令后分发处理逻辑交由业务层做具体的业务操作，然后将得到的 Model 给 View 显示。</span></p> 
<p>&nbsp;</p> 
<p><span style="color:#212121">Model</span></p> 
<pre><code class="language-java">class ModelImple : IModel{

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
        if (name.equals("zq") &amp;&amp; pwd.equals("123456")){
            if (onLoginSetListenter != null)
                onLoginSetListenter.onSuccess("登录成功")
        }else{
            if (onLoginSetListenter != null) {
                onLoginSetListenter.onError("登录失败")
            }
        }
    }
}</code></pre> 
<p>presenter</p> 
<pre><code class="language-java">class Presenter : BasePerenter&lt;IVew&gt;(){

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

}</code></pre> 
<p>activity</p> 
<pre><code class="language-java">class MainActivity : BaseActivity&lt;IVew,Presenter&gt;(),IVew{

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

}</code></pre> 
