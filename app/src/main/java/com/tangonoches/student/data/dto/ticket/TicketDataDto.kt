package com.tangonoches.student.data.dto.ticket

import com.tangonoches.student.data.models.Ticket
import java.text.SimpleDateFormat

data class TicketDataDto(
    val id: Int = 0,
    val lessons_left: Int = 0,
    val ticket: TicketDto = TicketDto()
)


fun TicketDataDto.toTicket(): Ticket {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ssssss")
    val endDate = dateFormat.parse(this.ticket.ticket_end_date.replace("T"," ").replace("Z"," "))
    val endDateFormat = SimpleDateFormat("dd.MM.yyyy")
    val endDateString = endDateFormat.format(endDate)
    return Ticket(
        type = this.ticket.ticketType.name,
        validTil = endDateString,
        lessonsLeft = this.lessons_left,
        lessonsTotal = this.ticket.ticketCount.lessons_count
    )
}