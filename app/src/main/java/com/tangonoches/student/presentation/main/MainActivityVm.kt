package com.tangonoches.student.presentation.main

import android.util.Log
import com.jakewharton.rxrelay2.BehaviorRelay
import com.tangonoches.student.data.models.Event
import com.tangonoches.student.data.models.Lesson
import com.tangonoches.student.data.models.Ticket
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.repositories.main.IMainRepository
import com.tangonoches.student.presentation.base.BaseVm
import javax.inject.Inject

class MainActivityVm @Inject constructor(
    private val mainRepository: IMainRepository,
    val prefsStorage: IPrefsStorage
) : BaseVm() {
    private val mockLessonsList = listOf<Lesson>(
        Lesson(
            "Суббота 28.12",
            "20:00 - 04:00",
            "\uD83C\uDF85Праздничная пижама-пати милонга",
            "пр. Кирова 32/1"
        ),
        Lesson(
            "Суббота 28.12",
            "20:00 - 04:00",
            "\uD83C\uDF85Праздничная пижама-пати милонга",
            "пр. Кирова 32/1"
        ),
        Lesson(
            "Суббота 28.12",
            "20:00 - 04:00",
            "\uD83C\uDF85Праздничная пижама-пати милонга",
            "пр. Кирова 32/1"
        ),
        Lesson(
            "Суббота 28.12",
            "20:00 - 04:00",
            "\uD83C\uDF85Праздничная пижама-пати милонга",
            "пр. Кирова 32/1"
        ),
        Lesson(
            "Суббота 28.12",
            "20:00 - 04:00",
            "\uD83C\uDF85Праздничная пижама-пати милонга",
            "пр. Кирова 32/1"
        )
    )
    private val mockEventsList = listOf<Event>(
        Event(
            "27 Декабря 20:00 - 03:00",
            "Урок от Юли и Антона «Шаг в танго»",
            "Проспект Кирова 32",
            ""
        ),
        Event(
            "27 Декабря 20:00 - 03:00",
            "Урок от Юли и Антона «Шаг в танго»",
            "Проспект Кирова 32",
            ""
        ),
        Event(
            "27 Декабря 20:00 - 03:00",
            "Урок от Юли и Антона «Шаг в танго»",
            "Проспект Кирова 32",
            ""
        ),
        Event(
            "27 Декабря 20:00 - 03:00",
            "Урок от Юли и Антона «Шаг в танго»",
            "Проспект Кирова 32",
            ""
        ),
        Event(
            "27 Декабря 20:00 - 03:00",
            "Урок от Юли и Антона «Шаг в танго»",
            "Проспект Кирова 32",
            ""
        )
    )

    val lessonsRelay = BehaviorRelay.create<List<Lesson>>()
    val eventsRelay = BehaviorRelay.create<List<Event>>()
    val ticketsRelay = BehaviorRelay.create<List<Ticket>>()

    val loadDataEvent = BehaviorRelay.create<Unit>()

    override fun createBinds() {
        Log.d("APP_TAG", "MainActivityVm createBinds")
        binds.addAll(loadDataEvent.subscribe {
            Log.d("APP_TAG", "MainActivityVm loadDataEvent.subscribe")
            binds.add(mainRepository.getLessons().subscribe({ lessons ->
                Log.d("APP_TAG","getLessons $lessons")
                lessonsRelay.accept(lessons) },
                { Log.d("APP_TAG", it.localizedMessage) }))
            binds.add(mainRepository.getEvents().subscribe({ events ->
                Log.d("APP_TAG","events $events")
                eventsRelay.accept(events) },
                { Log.d("APP_TAG", it.localizedMessage) }))
            binds.add(mainRepository.getTickets(prefsStorage.barcodeId).subscribe({ tickets ->
                Log.d("APP_TAG","tickets $tickets")
                ticketsRelay.accept(tickets) },
                { Log.d("APP_TAG", it.localizedMessage) }))
        })
    }
}