package com.tangonoches.student.domain.repositories.main

import android.util.Log
import com.tangonoches.student.data.requests.updateFcmToken.UpdateFcmTokenRequest
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.services.IFcmTokenApiService
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface IUpdateFcmTokenUseCase {
    fun updateToken(newToken: String): Completable
}

class UpdateFcmTokenUseCase(
    private val updateIFcmTokenApiService: IFcmTokenApiService,
    private val prefsStorage: IPrefsStorage
) : IUpdateFcmTokenUseCase {
    override fun updateToken(newToken: String): Completable {
        prefsStorage.lastFcmToken = newToken
        val apiToken = prefsStorage.apiToken?:""
        val barcodeId = prefsStorage.barcodeId
        Log.d("APP_TAG", "updateToken: newToken - $newToken apiToken - $apiToken");
        return updateIFcmTokenApiService.updateFcmToken(barcodeId, UpdateFcmTokenRequest(pushToken = newToken), apiToken)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}