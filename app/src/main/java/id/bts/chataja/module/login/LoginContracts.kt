package id.bts.chataja.module.login

import android.content.Context

object LoginContracts {

    interface LoginPresenterToViewInterface {
        val context: Context
        var presenter: LoginPresenter?
        // TODO: Declare Presenter to View methods
    }

    interface LoginPresentorToInteractorInterface {
        var presenter: LoginPresenter?
        // TODO: Declare Presenter to Interactor methods
        fun signIn(email: String, pass: String)
    }

    interface LoginInteractorToPresenterInterface {
        // TODO: Declare Interactor to Presenter methods
        fun successSignIn()
        fun failedSignIn()
    }

    interface LoginViewToPresenterInterface {
        var view: LoginActivity?
        var interector: LoginInteractor?
        var router: LoginRouter?
        // TODO: Declare View to Presenter methods
    }

    interface LoginPresenterToRouterInterface {
        companion object {
            var view: LoginActivity? = null

            fun configure(activity: LoginActivity) {}
        }
        // TODO: Declare Presenter to Router methods
        fun goToMain()
    }

}
