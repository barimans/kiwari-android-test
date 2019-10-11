package id.bts.chataja.component

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import id.bts.chataja.R

class ProgressDialog : DialogFragment() {

    companion object {
        var instance: ProgressDialog? = null

        fun getNewInstance(): ProgressDialog {
            instance = ProgressDialog()
            return instance as ProgressDialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.MessageDialogTheme)
    }

    override fun onStart() {
        super.onStart()
        val dialog = instance?.dialog
        if (dialog != null) {
            dialog.window.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL or Gravity.CENTER)
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.window.setLayout(width, height)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.layout_progress_dialog, container, false)

        return view
    }

}