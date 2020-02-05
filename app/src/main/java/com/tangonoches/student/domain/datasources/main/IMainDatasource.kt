package com.tangonoches.student.domain.datasources.main

import com.tangonoches.student.data.responces.TicketResponse
import com.tangonoches.student.data.responces.EventAnnouncesResponce
import com.tangonoches.student.data.responces.LessonAnnouncesResponce
import io.reactivex.Single

interface IMainDatasource {
    fun getLessonAnnounces():Single<LessonAnnouncesResponce>
    fun getEventAnnounces():Single<EventAnnouncesResponce>
    fun getTickets(barcodeId:Long):Single<TicketResponse>
}