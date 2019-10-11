package id.bts.chataja.module.login

import android.content.Intent
import id.bts.chataja.module.main.MainActivity

class LoginRouter : LoginContracts.LoginPresenterToRouterInterface {

    companion object {
        var view: LoginActivity? = null

        fun configure(activity: LoginActivity) {
            val presenter = LoginPresenter()
            val interactor = LoginInteractor()
            val router = LoginRouter()

            activity.presenter = presenter
            presenter.view = activity
            presenter.router = router
            presenter.interector = interactor
            interactor.presenter = presenter
            view = activity
        }
    }

    override fun goToMain() {
        val intent = Intent(view?.context, MainActivity::class.java)
        view?.startActivity(intent)
        view?.finish()
    }
}