package com.example.gmail

data class EmailModel(
    val username: String,
    val message: String,
    val avatar: String,
    val time: String,
    var selected: Boolean
){
    var showSecondary: Boolean = false
}