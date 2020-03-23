package com.tangonoches.student.data.models

import com.tangonoches.student.R

data class Lesson(
    val date: String?,
    val time: String,
    val name: String,
    val address: String,
    val groupId: Long = -1L
)

fun getLessonBackgroundByGroup(groupId: Long) = when (groupId) {
    1L -> R.drawable.bg_lesson_1
    2L -> R.drawable.bg_lesson_2
    3L -> R.drawable.bg_lesson_3
    4L -> R.drawable.bg_lesson_4
    5L -> R.drawable.bg_lesson_5
    else -> R.drawable.bg_lesson_1
}