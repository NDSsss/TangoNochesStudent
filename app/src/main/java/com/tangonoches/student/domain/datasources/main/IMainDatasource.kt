package com.tangonoches.student.domain.datasources.main

import com.tangonoches.student.data.responces.*
import io.reactivex.Single

interface IMainDatasource {
    fun getLessonAnnounces():Single<LessonAnnouncesResponce>
    fun getEventAnnounces():Single<EventAnnouncesResponce>
    fun getTickets(barcodeId:Long):Single<TicketResponse>
    fun getStudentsInfo(barcodeId: Long):Single<StudentInfoResponse>
    fun login(login: String, password: String): Single<LoginResponse>
}