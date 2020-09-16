package com.tangonoches.student.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tangonoches.student.R
import com.tangonoches.student.data.models.Event
import kotlinx.android.synthetic.main.item_event.view.*

class EventsAdapter : RecyclerView.Adapter<EventVh>() {

    var events: List<Event> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventVh =
        EventVh(LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false))

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventVh, position: Int) {
        val event = events[position]
        holder.itemView.item_event_tv_date.text = event.date
        holder.itemView.item_event_tv_name.text = event.name
        holder.itemView.item_event_tv_address.text = event.address
        holder.itemView.item_event_bg_photo.apply {
            Glide.with(this)
                .load(event.photoUrl)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.bg_event_photo)
                .into(this)
        }
    }
}

class EventVh(view: View) : RecyclerView.ViewHolder(view)