package com.example.tangonochesstudent.presentation.main

import androidx.lifecycle.ViewModel
import com.example.tangonochesstudent.data.Event
import com.example.tangonochesstudent.data.Lesson
import com.jakewharton.rxrelay2.BehaviorRelay

class MainActivityVm: ViewModel() {
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
    val lessonsRelay = BehaviorRelay.createDefault(mockLessonsList)
    val eventsRelay = BehaviorRelay.createDefault(mockEventsList)
}