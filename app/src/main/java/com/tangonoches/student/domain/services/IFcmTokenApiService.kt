package com.tangonoches.student.domain.services

import com.tangonoches.student.data.requests.updateFcmToken.UpdateFcmTokenRequest
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface IFcmTokenApiService {
    @POST("student/protected/notification/{Id}")
    fun updateFcmToken(
        @Path("Id") id: Long,
        @Body updateFcmTokenRequest: UpdateFcmTokenRequest,
        @Header("Authorization") apiToken: String
    ): Completable
}