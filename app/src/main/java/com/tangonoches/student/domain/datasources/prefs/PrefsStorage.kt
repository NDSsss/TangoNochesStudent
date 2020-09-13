package com.tangonoches.student.domain.datasources.prefs

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

const val PREFS_NAME = "BARCODE_PREFS"
const val BARCODDE_ID = "BARCODE_ID"
const val API_TOKEN = "api_token"
const val FCM_TOKEN = "FCM_TOKEN"

class PrefsStorage(private val context: Context) : IPrefsStorage {
    override var barcodeId: Long
        get() = prefs?.getLong(
            BARCODDE_ID,
            -1
        ) ?: -1
        set(value) {
            prefs?.edit()
                ?.putLong(BARCODDE_ID, value)?.apply()
        }

    override var apiToken: String?
        get() = prefs?.getString(API_TOKEN, null)
        set(value) {
            prefs?.edit()?.putString(API_TOKEN, value)?.apply()
        }

    override var lastFcmToken: String?
        get() = prefs?.getString(FCM_TOKEN, null)
        set(value) {
            Log.d("APP_TAG", "new token: $value")
            prefs?.edit()?.putString(FCM_TOKEN, value)?.apply()
        }

    private val prefs: SharedPreferences?
        get() = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
}