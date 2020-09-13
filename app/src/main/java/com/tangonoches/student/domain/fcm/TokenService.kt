package com.tangonoches.student.domain.fcm

import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.tangonoches.student.R
import com.tangonoches.student.di.ComponentsHolder
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.repositories.main.IUpdateFcmTokenUseCase
import com.tangonoches.student.presentation.login.LoginActivity

class TokenService : FirebaseMessagingService() {

    private val updateIUpdateFcmTokenUseCase: IUpdateFcmTokenUseCase get() = ComponentsHolder.mainComponent.provideIUpdateFcmTokenUseCase()

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        updateIUpdateFcmTokenUseCase.updateToken(p0).subscribe()
    }

    @Suppress("ForbiddenComment")
    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("APP_TAG", "TokenService onMessageReceived: notification ${message.notification}");
        Log.d("APP_TAG", "TokenService onMessageReceived: data ${message.data}");
        val notification = message.notification

        if (notification == null) { // data push
//            dataPushHandlers.forEach { it.handle(message) }
            // TODO: FTAND-33 process data push
        } else { // notification push
            // Note: not redirection to MainActivity since no password protection
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

            val channelId = getString(R.string.default_notification_channel_id)
            val commonNotification = notification.toCommonNotification(
                context = this,
                pendingIntent = pendingIntent,
                iconColor = getColorCompat(R.color.colorLessonStartGradient),
                channelId = channelId
            )
            sendNotification(
                notification = commonNotification,
                channelId = channelId,
                channelName = channelId
            )
        }
    }
}