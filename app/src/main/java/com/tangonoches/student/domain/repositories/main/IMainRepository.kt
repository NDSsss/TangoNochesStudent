package com.tangonoches.student.domain.repositories.main

import com.tangonoches.student.data.models.*
import com.tangonoches.student.data.responces.LoginResponse
import io.reactivex.Completable
import io.reactivex.Single

interface IMainRepository {
    fun getLessons(): Single<List<Lesson>>
    fun getEvents(): Single<List<Event>>
    fun getTickets(barcodeId: Long): Single<List<Ticket>>
    fun getStudentInfo(barcodeId: Long): Single<StudentInfoModel>

    fun getAllDividedLessonsList(): Single<List<BaseAllListsItem>>
    fun getAllDividedEventsList(): Single<List<BaseAllListsItem>>
    fun login(login: String, password: String): Completable
}