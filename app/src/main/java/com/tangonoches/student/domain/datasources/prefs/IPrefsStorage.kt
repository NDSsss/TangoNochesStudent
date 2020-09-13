package com.tangonoches.student.domain.datasources.prefs

interface IPrefsStorage {
    var barcodeId: Long
    var apiToken: String?
    var lastFcmToken: String?
}