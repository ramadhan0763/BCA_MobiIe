package com.bank.bcamobiie.utils

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.net.Uri
import java.util.Locale

object Utils {
    fun getCurrentDateWithFormat(): String {
        val dateFormat = SimpleDateFormat("ddMMyy", Locale.getDefault())
        val currentDate = Calendar.getInstance().time
        return dateFormat.format(currentDate)
    }

    fun getCurrentTimeWithFormat(): String {
        val timeFormat = SimpleDateFormat("HHmmss", Locale.getDefault())
        val currentTime = Calendar.getInstance().time
        return timeFormat.format(currentTime)
    }

    private fun sendMessage(phoneNumber: String, message: String) {
        val uri = Uri.parse("smsto:$phoneNumber")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", message)
    }

    val sendMessageTrigger = sendMessage("89888", "BCA mobile 1\n" +
            "Kirim SMS utk AKTIVASI\n" +
            "HATI HATI Modus Penipuan\n" +
            "No. Ref:VGRCAOEK1263668F\n" +
            "Tgl/Jam: ${Utils.getCurrentDateWithFormat()} ${Utils.getCurrentTimeWithFormat()}")

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == inputRequestCode){
//            if (isInputActive){
//                isInputActive = false
//                val intent = Intent(this, SuccesInputActivity::class.java)
//                startActivity(intent)
//            }
//
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        if (isInputActive){
//            isInputActive = false
//            val intent = Intent(this, SuccesInputActivity::class.java)
//            startActivity(intent)
//        }
//    }

    fun String.removeHyphens(): String {
        return this.replace("-", "")
    }

}