package id.bts.chataja.module.main

import id.bts.chataja.model.Message
import id.bts.chataja.model.User

class MainPresenter : MainContracts.MainViewToPresenterInterface, MainContracts.MainInteractorToPresenterInterface {

    override var view: MainActivity? = null
    override var interector: MainInteractor? = null
    override var router: MainRouter? = null

    override fun fetchDataUser(data: User) {
        view?.showDataUser(data)
    }

    override fun fetchDataMessage(data: List<Message>) {
        view?.showDataMessage(data)
    }

    override fun failedFetchUser() {

    }
}
