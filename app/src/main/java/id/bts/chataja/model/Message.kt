package id.bts.chataja.model

data class Message(
    var content: String? = null,
    var time: Long? = null,
    var sender: User? = null
)