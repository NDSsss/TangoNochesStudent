package com.tangonoches.student.domain.fcm

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.media.RingtoneManager
import androidx.annotation.ColorInt
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage
import com.tangonoches.student.R

/**
 * Converts notification message to actual notification
 */
fun RemoteMessage.Notification.toCommonNotification(
    context: Context,
    pendingIntent: PendingIntent,
    channelId: String,
    @ColorInt iconColor: Int
): Notification {
    val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setColor(iconColor)
        .setContentTitle(title)
        .setContentText(body)
        .setAutoCancel(true)
        .setSound(defaultSoundUri)
        .setContentIntent(pendingIntent)
        .build()
}

fun createCommonNotification(
    title: String,
    message: String,
    context: Context,
    pendingIntent: PendingIntent,
    channelId: String,
    @ColorInt iconColor: Int
): Notification {
    val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setColor(iconColor)
        .setContentTitle(title)
        .setContentText(message)
        .setAutoCancel(true)
        .setSound(defaultSoundUri)
        .setContentIntent(pendingIntent)
        .build()
}
