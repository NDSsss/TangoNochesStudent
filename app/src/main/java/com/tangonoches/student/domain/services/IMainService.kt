package com.tangonoches.student.domain.services

import com.tangonoches.student.data.requests.login.LoginRequest
import com.tangonoches.student.data.responces.*
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IMainService {
    @GET("student/lessonAnnounces")
    fun getLessonAnnounces(): Single<LessonAnnouncesResponce>

    @GET("student/eventAnnounces")
    fun getEventAnnounces(): Single<EventAnnouncesResponce>

    @GET("student/student")
    fun getTickets(@Query("barcode_id") barcodeId: Long): Single<TicketResponse>

    @GET("student/studentInfo")
    fun getStudentInfo(@Query("barcode_id") barcodeId: Long): Single<StudentInfoResponse>

    @POST("student/login")
    fun login(@Body request: LoginRequest): Single<LoginResponse>
}