package com.tangonoches.student.data.dto.ticket

import com.tangonoches.student.data.models.Ticket

data class TicketDto(
    val ticketCount: TicketCountDto = TicketCountDto(),
    val ticketType: TicketTypeDto = TicketTypeDto(),
    val ticket_end_date: String = "",
    val ticket_start_date: String = ""
)