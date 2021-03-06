package com.tangonoches.student.data.dto

import com.tangonoches.student.data.models.AllEventsModel
import com.tangonoches.student.data.models.Event
import java.text.SimpleDateFormat
import java.util.*

data class EventAnnounceDto(
    val address: String = "",
    val created_at: String = "",
    val deleted_at: String = "",
    val end_date: String = "",
    val extra_info: String = "",
    val id: Int = 0,
    val is_active: Boolean = false,
    val name: String = "",
    val start_date: String = "",
    val updated_at: String = "",
    val image: String = ""
)

fun EventAnnounceDto.toEvent(): Event {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val startDate = dateFormat.parse(this.start_date)
    val endDate = dateFormat.parse(this.end_date)
    val wantedStartDate = SimpleDateFormat("dd MMMM, E HH:mm")
    val wantedEndDate = SimpleDateFormat("HH:mm")
    val startDateString = wantedStartDate.format(startDate)
    val endDateString = wantedEndDate.format(endDate)
    val resultDateString = if (endDate.after(Calendar.getInstance().time)) {
        startDateString.plus(" - ").plus(endDateString)
    } else {
        null
    }
    return Event(
        date = resultDateString,
        name = this.name,
        address = this.address,
        photoUrl = image
    )
}

fun EventAnnounceDto.toAllEventModel(): AllEventsModel {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val startDate: Date = dateFormat.parse(this.start_date)
    val endDate = dateFormat.parse(this.end_date)
    val wantedStartDate = SimpleDateFormat("dd, MMMM HH:mm")
    val wantedEndDate = SimpleDateFormat("HH:mm")
    val startDateString = wantedStartDate.format(startDate)
    val endDateString = wantedEndDate.format(endDate)
    val resultDateString = startDateString.plus(" - ").plus(endDateString)
    val result = AllEventsModel(
        date = resultDateString,
        name = this.name,
        address = this.address,
        rawStartDate = startDate
    )
    return result
}