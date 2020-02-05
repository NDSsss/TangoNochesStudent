package com.tangonoches.student.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tangonoches.student.R
import com.tangonoches.student.data.models.Lesson
import kotlinx.android.synthetic.main.item_lesson.view.*

class LessonsAdapter : RecyclerView.Adapter<LessonsVh>() {

    var lessons: List<Lesson> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsVh =
        LessonsVh(LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false))

    override fun getItemCount(): Int = lessons.size

    override fun onBindViewHolder(holder: LessonsVh, position: Int) {
        val lesson = lessons[position]
        holder.itemView.item_lesson_tv_date.text = lesson.date
        holder.itemView.item_lesson_tv_time.text = lesson.time
        holder.itemView.item_lesson_tv_name.text = lesson.name
        holder.itemView.item_lesson_tv_address.text = lesson.address
    }
}

class LessonsVh(view: View) : RecyclerView.ViewHolder(view)