package id.bts.chataja.module.main

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import id.bts.chataja.model.Message
import id.bts.chataja.model.User

class MainInteractor : MainContracts.MainPresentorToInteractorInterface {

    override var presenter: MainPresenter? = null

    override fun fetchUser(uid: String) {
        presenter?.view?.database!!.getReference("users")
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val dataUser = dataSnapshot.child(uid).getValue(User::class.java)
                    presenter?.fetchDataUser(dataUser!!)
                }

                override fun onCancelled(p0: DatabaseError) {
                    presenter?.failedFetchUser()
                }
            })
    }

    override fun postMessage(message: Message) {
        presenter?.view?.database!!.reference
            .child("message").push().setValue(message)

    }

    override fun fetchListMessage() {
        var listMessage = arrayListOf<Message>()

        presenter?.view?.database!!.getReference("message")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val snap = dataSnapshot.children
                    snap.forEach {
                        val key = it.key
                        val data = dataSnapshot.child(key!!).getValue(Message::class.java)
                        listMessage.add(data!!)
                    }
                    presenter?.fetchDataMessage(listMessage)
                }

                override fun onCancelled(p0: DatabaseError) {

                }
            })
    }
}
