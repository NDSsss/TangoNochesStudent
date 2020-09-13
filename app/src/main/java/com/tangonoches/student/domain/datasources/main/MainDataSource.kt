package com.tangonoches.student.domain.datasources.main

import com.tangonoches.student.data.requests.login.LoginRequest
import com.tangonoches.student.data.responces.*
import com.tangonoches.student.domain.services.IMainService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainDataSource(
    private val mainService: IMainService
) : IMainDatasource {
    override fun getLessonAnnounces(): Single<LessonAnnouncesResponce> =
        mainService.getLessonAnnounces()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getEventAnnounces(): Single<EventAnnouncesResponce> =
        mainService.getEventAnnounces()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getTickets(barcodeId: Long): Single<TicketResponse> =
        mainService.getTickets(barcodeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun getStudentsInfo(barcodeId: Long): Single<StudentInfoResponse> =
        mainService.getStudentInfo(barcodeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun login(login: String, password: String): Single<LoginResponse> =
        mainService.login(LoginRequest(login, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}