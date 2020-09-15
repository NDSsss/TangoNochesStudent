package com.tangonoches.student.domain.fcm

import com.google.gson.annotations.SerializedName

data class TangoDataPush(
    @SerializedName("message_body") val message: String,
    @SerializedName("message_title") val title: String,
    @SerializedName("type") val type: String
) {
}