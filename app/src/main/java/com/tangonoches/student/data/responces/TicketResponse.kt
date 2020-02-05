package com.tangonoches.student.data.responces

import com.tangonoches.student.data.dto.ticket.TicketDataDto

data class TicketResponse(
    val `data`: List<TicketDataDto> = listOf()
)