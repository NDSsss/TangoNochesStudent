package com.tangonoches.student.data.dto

import com.tangonoches.student.data.models.Lesson
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class LessonAnnounceDto(
    val address: String = "",
    val created_at: String = "",
    val deleted_at: String = "",
    val end_date: String = "",
    val extra_info: String = "",
    val group: Group = Group(),
    val group_id: Int = 0,
    val id: Int = 0,
    val is_active: Boolean = false,
    val name: String = "",
    val start_date: String = "",
    val updated_at: String = ""
)

fun LessonAnnounceDto.toLesson(): Lesson {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val startDate = dateFormat.parse(this.start_date)
    val endDate = dateFormat.parse(this.end_date)
    val wantedDateFormat = SimpleDateFormat("EEEE dd.MM")
    val dateString = wantedDateFormat.format(startDate).capitalize()
    val timeFormat = SimpleDateFormat("HH:mm")
    val timeString = timeFormat.format(startDate).plus(" - ").plus(timeFormat.format(endDate))
    return Lesson(
        date = dateString,
        time = timeString,
        name = this.name,
        address = this.address
    )
}