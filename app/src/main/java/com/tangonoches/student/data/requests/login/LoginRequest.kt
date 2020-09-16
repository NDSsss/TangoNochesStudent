package com.tangonoches.student.data.requests.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("bar_code") val barCode: String,
    @SerializedName("password") val password: String
) {
}