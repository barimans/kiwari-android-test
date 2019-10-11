package id.bts.chataja.module.login

import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.text.TextUtils
import com.google.firebase.auth.FirebaseAuth
import id.bts.chataja.R;
import id.bts.chataja.base.BaseView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

// TODO: Add activity to manifest
class LoginActivity : BaseView(), LoginContracts.LoginPresenterToViewInterface {

    var edtEmail: String? = null
    var edtPass: String? = null

    // MARK: Properties
    override var presenter: LoginPresenter? = null
    override val context: Context = this

    // MARK: Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        LoginRouter.configure(this)
        super.onCreate(savedInstanceState)
        // TODO: Define layout for this activity
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {

            edtEmail = edt_email.text.toString().trim()
            edtPass = edt_password.text.toString().trim()
            if (TextUtils.isEmpty(edtEmail) && TextUtils.isEmpty(edtPass)){
                toast("Email and Password is required!")
            }else if (TextUtils.isEmpty(edtEmail) || TextUtils.isEmpty(edtPass)){
                toast("Email or Password is required!")
            }else if (!TextUtils.isEmpty(edtEmail) && !TextUtils.isEmpty(edtPass)){
                showProgressDialog()
                presenter?.interector?.signIn(edtEmail!!, edtPass!!)
            }

        }

    }

}
