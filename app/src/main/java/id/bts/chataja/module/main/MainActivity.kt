package id.bts.chataja.module.main

import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.bts.chataja.R;
import id.bts.chataja.base.BaseView
import id.bts.chataja.model.Message
import id.bts.chataja.model.User
import id.bts.chataja.module.main.adapter.MessageAdapter
import id.bts.chataja.utils.DateUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

// TODO: Add activity to manifest
class MainActivity : BaseView(), MainContracts.MainPresenterToViewInterface {

    var dataUser: User? = null
    var dataMessage: Message? = Message()
    var messageAdapter = MessageAdapter()
    var listMessage: MutableList<Message> = mutableListOf()

    // MARK: Properties
    override var presenter: MainPresenter? = null
    override val context: Context = this

    // MARK: Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        MainRouter.configure(this)
        super.onCreate(savedInstanceState)
        // TODO: Define layout for this activity
        setContentView(R.layout.activity_main)

        if (auth.currentUser != null){
            presenter?.interector?.fetchUser(auth.uid!!)
            presenter?.interector?.fetchListMessage()
        }

        recycler_message.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = messageAdapter
        }

        btn_message.setOnClickListener {

            val contentMessage = edt_message.text.toString().trim()
            val setTime = DateUtils.getCurrentTimeLong()
            dataMessage?.content = contentMessage
            dataMessage?.time = setTime
            dataMessage?.sender = dataUser
            if (!TextUtils.isEmpty(contentMessage)){
                presenter?.interector?.postMessage(dataMessage!!)
                edt_message.setText("")
                hideKeyboard(this)
            }

        }

        btn_logout.setOnClickListener {
            alert("Are you sure want to logout") {
                title = "Logout"
                yesButton {
                    auth.signOut()
                    presenter?.router?.goToLogin()
                }
                noButton {  }
            }.show()

        }
    }

    fun showDataUser(data: User){
        Picasso.get().load(data.avatar).into(avatar_user)
        txt_user.text = data.name
        dataUser = data
    }

    fun showDataMessage(data: List<Message>){
        presenter?.interector?.fetchListMessage()
        messageAdapter.data = data
        if (data.isNotEmpty()) {
            recycler_message.smoothScrollToPosition(data.size - 1)
        }
        messageAdapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser == null){
            presenter?.router?.goToLogin()
        }
    }

    fun hideKeyboard(context: Activity){
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(context.currentFocus!!.windowToken, 0)
    }

}
