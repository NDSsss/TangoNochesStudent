package com.tangonoches.student.domain.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.SystemClock

/**
 * Sent notification to given chanel
 */
fun Context.sendNotification(
    notification: Notification,
    channelId: String,
    channelName: String,
    notificationId: Int = getUniqueId()
) {
    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Since android Oreo notification channel is needed.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
    }

    notificationManager.notify(notificationId, notification)
}

/**
 * needed to always show next notification, used in conjunction with setAutoCancel(true)
 */
@Suppress("MagicNumber")
fun getUniqueId(): Int {
    // Note: needed to always show next notification
    return (SystemClock.elapsedRealtime() / 1000).toInt()
}
