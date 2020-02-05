package com.tangonoches.student.domain.repositories.main

import com.tangonoches.student.data.dto.ticket.toTicket
import com.tangonoches.student.data.dto.toEvent
import com.tangonoches.student.data.dto.toLesson
import com.tangonoches.student.data.models.Event
import com.tangonoches.student.data.models.Lesson
import com.tangonoches.student.data.models.Ticket
import com.tangonoches.student.domain.datasources.main.IMainDatasource
import io.reactivex.Single

class MainRepository(
    private val mainDatasource: IMainDatasource
) : IMainRepository {
    override fun getLessons(): Single<List<Lesson>> =
        mainDatasource.getLessonAnnounces().map { response -> response.data.map { it.toLesson() } }

    override fun getEvents(): Single<List<Event>> =
        mainDatasource.getEventAnnounces().map { response -> response.data.map { it.toEvent() } }

    override fun getTickets(barcodeId: Long): Single<List<Ticket>> =
        mainDatasource.getTickets(barcodeId).map { response -> response.data.map { item -> item.toTicket() } }
}