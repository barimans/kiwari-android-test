package id.bts.chataja.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateUtils{

    fun getCurrentTimeLong(): Long {
        val date = Date()
        val currentTime = date.time

        return currentTime
    }

    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd MM yyyy, HH:mm")
        return format.format(date)
    }
}