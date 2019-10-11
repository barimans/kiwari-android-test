package id.bts.chataja.module.main

import android.content.Intent
import id.bts.chataja.module.login.LoginActivity

class MainRouter : MainContracts.MainPresenterToRouterInterface {

    companion object {
        var view: MainActivity? = null

        fun configure(activity: MainActivity) {
            val presenter = MainPresenter()
            val interactor = MainInteractor()
            val router = MainRouter()

            activity.presenter = presenter
            presenter.view = activity
            presenter.router = router
            presenter.interector = interactor
            interactor.presenter = presenter
            view = activity
        }
    }

    override fun goToLogin() {
        val intent = Intent(view?.context, LoginActivity::class.java)
        view?.startActivity(intent)
        view?.finish()
    }
}