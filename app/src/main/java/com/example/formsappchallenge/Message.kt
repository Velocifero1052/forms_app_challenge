package com.example.formsappchallenge

import java.io.Serializable

data class Message(
    val lastName: String,
    val firstName: String,
    val email: String,
    val subscribe: Boolean,
    val phoneNumber: String,
    val accountType: String?
) : Serializable {

    fun getSubscription(): String {
        return if (subscribe) "subscribed" else "Not subscribed"
    }

}