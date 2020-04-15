package com.tangonoches.student.domain.datasources.main

import com.tangonoches.student.data.responces.TicketResponse
import com.tangonoches.student.data.responces.EventAnnouncesResponce
import com.tangonoches.student.data.responces.LessonAnnouncesResponce
import com.tangonoches.student.data.responces.StudentInfoResponse
import io.reactivex.Single

interface IMainDatasource {
    fun getLessonAnnounces():Single<LessonAnnouncesResponce>
    fun getEventAnnounces():Single<EventAnnouncesResponce>
    fun getTickets(barcodeId:Long):Single<TicketResponse>
    fun getStudentsInfo(barcodeId: Long):Single<StudentInfoResponse>
}