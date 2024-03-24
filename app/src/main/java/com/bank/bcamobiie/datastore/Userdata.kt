package com.bank.bcamobiie.datastore

data class Userdata(
    val noRek : String,
    val pin : String,
    val isLogin : Boolean = false
)