package com.upar24.chattingtrading.data.remote.requests

data class UpdateUserRequest(
    val name:String?="",
    val clubName:String?="",
    val ign:String?="",
    val bio:String?=""
)