package com.tangonoches.student.domain.repositories.main

import com.tangonoches.student.data.dto.ticket.toTicket
import com.tangonoches.student.data.dto.toAllEventModel
import com.tangonoches.student.data.dto.toAllLessonModel
import com.tangonoches.student.data.dto.toEvent
import com.tangonoches.student.data.dto.toLesson
import com.tangonoches.student.data.models.*
import com.tangonoches.student.domain.datasources.main.IMainDatasource
import io.reactivex.Single

class MainRepository(
    private val mainDatasource: IMainDatasource
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
        mainDatasource.getTickets(barcodeId).map { response -> response.data.map { item -> item.toTicket() } }

    override fun getAllDividedLessonsList(): Single<List<BaseAllListsItem>> =
        mainDatasource.getLessonAnnounces().map { response ->
            response.data.map { it.toAllLessonModel() }.toAllDividedLessonsList()
        }

    override fun getAllDividedEventsList(): Single<List<BaseAllListsItem>> =
        mainDatasource.getEventAnnounces().map { response ->
            response.data.map { it.toAllEventModel() }.toAllDividedEventsList()
        }
}