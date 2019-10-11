package id.bts.chataja.utils

import com.orhanobut.hawk.Hawk

class PreferenceHelper{

    companion object{
        var instance = PreferenceHelper()
    }

    fun setLogin(status: Boolean) {
        Hawk.put(KEY_LOGIN, status)
    }

    fun isLogin(): Boolean {
        return Hawk.get(KEY_LOGIN, false)
    }
}