package com.tangonoches.student.data.requests.updateFcmToken

import com.google.gson.annotations.SerializedName

data class UpdateFcmTokenRequest(
    @SerializedName("push_token") val pushToken: String,
    @SerializedName("platform") val platform: String = "android"
)