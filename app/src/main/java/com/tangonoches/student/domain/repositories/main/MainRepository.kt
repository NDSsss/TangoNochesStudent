package com.tangonoches.student.domain.repositories.main

import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.firebase.iid.FirebaseInstanceId
import com.tangonoches.student.data.dto.ticket.toTicket
import com.tangonoches.student.data.dto.toAllEventModel
import com.tangonoches.student.data.dto.toAllLessonModel
import com.tangonoches.student.data.dto.toEvent
import com.tangonoches.student.data.dto.toLesson
import com.tangonoches.student.data.models.*
import com.tangonoches.student.data.responces.toModel
import com.tangonoches.student.domain.datasources.main.IMainDatasource
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.fcm.TokenService
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRepository(
    private val mainDatasource: IMainDatasource,
    private val prefsStorage: IPrefsStorage,
    private val updateFcmTokenUseCase: IUpdateFcmTokenUseCase
) : IMainRepository {
    override fun getLessons(): Single<List<Lesson>> =
        mainDatasource.getLessonAnnounces().map { response ->
            response.data.map { it.toLesson() }.filter { it.date != null }
        }

    override fun getEvents(): Single<List<Event>> =
        mainDatasource.getEventAnnounces().map { response ->
            response.data.map { it.toEvent() }.filter { it.date != null }
        }

    override fun getTickets(barcodeId: Long): Single<List<Ticket>> =
        mainDatasource.getTickets(barcodeId)
            .map { response -> response.data.map { item -> item.toTicket() } }

    override fun getStudentInfo(barcodeId: Long): Single<StudentInfoModel> =
        mainDatasource.getStudentsInfo(barcodeId).map { response -> response.toModel() }

    override fun getAllDividedLessonsList(): Single<List<BaseAllListsItem>> =
        mainDatasource.getLessonAnnounces().map { response ->
            response.data.map { it.toAllLessonModel() }.toAllDividedLessonsList()
        }

    override fun getAllDividedEventsList(): Single<List<BaseAllListsItem>> =
        mainDatasource.getEventAnnounces().map { response ->
            response.data.map { it.toAllEventModel() }.toAllDividedEventsList()
        }

    override fun login(login: String, password: String): Completable =
        Completable.fromSingle(
            mainDatasource.login(login, password)
                .doOnSuccess {
                    prefsStorage.barcodeId = login.toLong()
                    prefsStorage.apiToken = it.apiToken
                }
        ).andThen(sendFcmToken())

    private fun sendFcmToken(): Completable {
        return Single.fromCallable { Tasks.await(FirebaseInstanceId.getInstance().instanceId).token}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapCompletable { updateFcmTokenUseCase.updateToken(it) }
//        return updateFcmTokenUseCase.updateToken(
//            token
//        )
    }
//        Completable.fromCallable {
//            FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener {
//                val token = it.result?.token
//                Log.d("APP_TAG", "send fcmToken addOnCompleteListener $token")
//                if (token == null) {
//                    return@addOnCompleteListener
//                } else {
//                    updateFcmTokenUseCase.updateToken(token)
//                }
//            }
//        }
}