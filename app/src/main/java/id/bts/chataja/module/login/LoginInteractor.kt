package id.bts.chataja.module.login

class LoginInteractor : LoginContracts.LoginPresentorToInteractorInterface {

    override var presenter: LoginPresenter? = null

    override fun signIn(email: String, pass: String) {
        presenter?.view?.auth!!.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    presenter?.successSignIn()
                }else{
                    presenter?.failedSignIn()
                }
            }
    }
}
