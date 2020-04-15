package com.tangonoches.student.data.responces

import com.tangonoches.student.data.dto.ticket.TicketDataDto
import com.tangonoches.student.data.dto.ticket.toTicket
import com.tangonoches.student.data.models.StudentInfoModel

data class StudentInfoResponse(
    val tickets: List<TicketDataDto> = listOf(),
    val points: Int = 0
)

fun StudentInfoResponse.toModel(): StudentInfoModel =
    StudentInfoModel(
        tickets = this.tickets.map { it.toTicket() },
        points = this.points
    )