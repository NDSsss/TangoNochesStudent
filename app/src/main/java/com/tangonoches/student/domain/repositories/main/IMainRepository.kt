package com.tangonoches.student.domain.repositories.main

import com.tangonoches.student.data.models.Event
import com.tangonoches.student.data.models.Lesson
import com.tangonoches.student.data.models.Ticket
import io.reactivex.Single

interface IMainRepository {
    fun getLessons():Single<List<Lesson>>
    fun getEvents():Single<List<Event>>
    fun getTickets(barcodeId:Long):Single<List<Ticket>>
}