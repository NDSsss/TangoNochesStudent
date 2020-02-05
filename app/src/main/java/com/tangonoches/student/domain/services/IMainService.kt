package com.tangonoches.student.domain.services

import com.tangonoches.student.data.responces.TicketResponse
import com.tangonoches.student.data.responces.EventAnnouncesResponce
import com.tangonoches.student.data.responces.LessonAnnouncesResponce
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IMainService {
    @GET("student/lessonAnnounces")
    fun getLessonAnnounces(): Single<LessonAnnouncesResponce>

    @GET("student/eventAnnounces")
    fun getEventAnnounces(): Single<EventAnnouncesResponce>

    @GET("student/student")
    fun getTickets(@Query("barcode_id") barcodeId: Long): Single<TicketResponse>
}