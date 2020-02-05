package com.tangonoches.student.domain.datasources.prefs

import android.content.Context

const val PREFS_NAME = "BARCODE_PREFS"
const val BARCODDE_ID = "BARCODE_ID"

class PrefsStorage(private val context: Context) : IPrefsStorage {
    override var barcodeId: Long
        get() = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)?.getLong(
            BARCODDE_ID,
            1
        ) ?: 1
        set(value) {
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)?.edit()
                ?.putLong(BARCODDE_ID, value)?.apply()
        }

}