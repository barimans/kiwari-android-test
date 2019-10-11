package id.bts.chataja.module.login

import org.jetbrains.anko.toast

class LoginPresenter : LoginContracts.LoginViewToPresenterInterface,
    LoginContracts.LoginInteractorToPresenterInterface {

    override var view: LoginActivity? = null
    override var interector: LoginInteractor? = null
    override var router: LoginRouter? = null

    override fun successSignIn() {
        view?.hideProgressDialog()
        router?.goToMain()
    }

    override fun failedSignIn() {
        view?.hideProgressDialog()
        view?.toast("Oopps authentication failed")
    }
}
