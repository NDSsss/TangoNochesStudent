package com.tangonoches.student.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tangonoches.student.R
import com.tangonoches.student.data.models.Lesson
import com.tangonoches.student.data.models.getLessonBackgroundByGroup
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
        holder.bind(lessons[position])
    }
}

class LessonsVh(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(lesson: Lesson) {
        itemView.item_lesson_tv_date.text = lesson.date
        itemView.item_lesson_tv_time.text = lesson.time
        itemView.item_lesson_tv_name.text = lesson.name
        itemView.item_lesson_tv_address.text = lesson.address
        itemView.item_lesson_cl_bg.background = ContextCompat.getDrawable(itemView.context, getLessonBackgroundByGroup(lesson.groupId))
    }
}