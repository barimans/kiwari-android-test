package id.bts.chataja.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.hawk.Hawk
import id.bts.chataja.component.ProgressDialog

open class BaseView: AppCompatActivity(){

    lateinit var auth: FirebaseAuth
    lateinit var database: FirebaseDatabase

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Hawk.init(applicationContext).build()
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        context = this
    }

    fun showProgressDialog(tag: String = "showProgressDialog") {
        val editNameDialogFragment = ProgressDialog.getNewInstance()
        editNameDialogFragment.show(supportFragmentManager, tag)
    }

    fun hideProgressDialog() {
        if (ProgressDialog.instance != null) ProgressDialog.instance?.dismiss()
    }
}