package com.tangonoches.student.data.responces

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("api_token") val apiToken: String
)