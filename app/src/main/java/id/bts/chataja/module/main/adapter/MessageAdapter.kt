package id.bts.chataja.module.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.bts.chataja.R
import id.bts.chataja.model.Message
import id.bts.chataja.utils.DateUtils
import kotlinx.android.synthetic.main.item_list_message.view.*

class MessageAdapter(var data: List<Message> = listOf()) : RecyclerView.Adapter<MessageViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_message, parent, false))
    }

    override fun getItemCount(): Int {
        if (data != null) {
            return data.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        if (data != null) {
            holder.bindData(data[position])
        }
    }
}

class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindData(data: Message){
        itemView.txt_name.text = data.sender?.name
        itemView.txt_content.text = data.content
        val date = DateUtils.convertLongToTime(data.time!!)
        itemView.txt_date.text = date
    }
}
