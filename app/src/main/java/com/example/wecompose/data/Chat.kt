package com.example.wecompose.data

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.wecompose.R

data class Chat(var friend: User, var msgs: MutableList<Msg>)

data class Msg(val from: User, val text: String, val time: String){
    var read by mutableStateOf(true)
}

data class User(val id: String, val name: String, @DrawableRes val avatar: Int) {
    companion object {
        val Me = User("rengWuXian", "仍物线-xx", R.drawable.avatar_rengwuxian)
    }
}