package id.bts.chataja.module.splash

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import id.bts.chataja.R
import id.bts.chataja.base.BaseView
import id.bts.chataja.module.login.LoginActivity
import id.bts.chataja.module.main.MainActivity
import id.bts.chataja.utils.PreferenceHelper

class SplashActivity : BaseView() {

    private val delaySplash : Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        navigateToActivity(this, MainActivity::class.java)

    }

    private fun navigateToActivity(activity: Activity, cls : Class<*>){
        Handler().postDelayed({
            activity.startActivity(Intent(activity, cls))
            activity.finish()
        }, delaySplash)
    }
}
