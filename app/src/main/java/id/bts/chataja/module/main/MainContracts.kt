package id.bts.chataja.module.main

import android.content.Context
import id.bts.chataja.model.Message
import id.bts.chataja.model.User

object MainContracts {

    interface MainPresenterToViewInterface {
        val context: Context
        var presenter: MainPresenter?
        // TODO: Declare Presenter to View methods
    }

    interface MainPresentorToInteractorInterface {
        var presenter: MainPresenter?
        // TODO: Declare Presenter to Interactor methods
        fun fetchUser(uid: String)
        fun postMessage(message: Message)
        fun fetchListMessage()
    }

    interface MainInteractorToPresenterInterface {
        // TODO: Declare Interactor to Presenter methods
        fun fetchDataUser(data: User)
        fun failedFetchUser()
        fun fetchDataMessage(data: List<Message>)
    }

    interface MainViewToPresenterInterface {
        var view: MainActivity?
        var interector: MainInteractor?
        var router: MainRouter?
        // TODO: Declare View to Presenter methods
    }

    interface MainPresenterToRouterInterface {
        companion object {
            var view: MainActivity? = null

            fun configure(activity: MainActivity) {}
        }
        // TODO: Declare Presenter to Router methods
        fun goToLogin()
    }

}
