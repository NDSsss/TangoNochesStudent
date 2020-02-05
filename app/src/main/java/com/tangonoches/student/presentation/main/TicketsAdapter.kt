package com.tangonoches.student.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tangonoches.student.R
import com.tangonoches.student.data.models.Ticket
import kotlinx.android.synthetic.main.item_ticket.view.*

class TicketsAdapter : RecyclerView.Adapter<TicketsVh>() {
    var tickets: List<Ticket> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsVh =
        TicketsVh(LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false))

    override fun getItemCount(): Int = tickets.size

    override fun onBindViewHolder(holder: TicketsVh, position: Int) {
        val ticket = tickets[position]
        holder.itemView.item_ticket_tv_title.text = ticket.type
        holder.itemView.item_ticket_tv_until_date.text = ticket.validTil
        holder.itemView.item_ticket_lessons_left.text = ticket.lessonsLeft.toString()
        holder.itemView.item_ticket_lessons_all.text = "/".plus(ticket.lessonsTotal.toString())
        holder.itemView.item_ticket.setImageDrawable(
            holder.itemView.item_ticket.resources.getDrawable(
                when {
                    ticket.lessonsLeft >= 4 -> R.drawable.ic_bg_ticket_green
                    ticket.lessonsLeft in 2..3 -> R.drawable.ic_bg_ticket_orange
                    ticket.lessonsLeft in 0..1 -> R.drawable.ic_bg_ticket_red
                    else -> R.drawable.ic_bg_ticket_green
                }
            )
        )
    }
}

class TicketsVh(itemView: View) : RecyclerView.ViewHolder(itemView)