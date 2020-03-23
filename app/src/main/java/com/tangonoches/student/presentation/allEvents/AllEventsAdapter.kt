package com.tangonoches.student.presentation.allEvents

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tangonoches.student.R
import com.tangonoches.student.data.models.AllEventsModel
import com.tangonoches.student.data.models.AllLessonsModel
import com.tangonoches.student.data.models.BaseAllListsItem
import com.tangonoches.student.data.models.getLessonBackgroundByGroup
import kotlinx.android.synthetic.main.item_all_divider.view.*
import kotlinx.android.synthetic.main.item_all_event.view.*
import kotlinx.android.synthetic.main.item_all_lesson.view.*

const val ALL_DIVIDER_TYPE = 1
const val ALL_EVENT_TYPE = 2
const val ALL_LESSON_TYPE = 3

class AllEventsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var events: List<BaseAllListsItem> = listOf()
        set(value) {
            Log.d("APP_TAG", "AllEventsAdapter" + value.size.toString())
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return when (events[position]) {
            is AllEventsModel -> ALL_EVENT_TYPE
            is AllLessonsModel -> ALL_LESSON_TYPE
            else -> ALL_DIVIDER_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ALL_EVENT_TYPE -> AllEventsVh(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_all_event,
                    parent,
                    false
                )
            )
            ALL_LESSON_TYPE -> AllLessonsVh(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_all_lesson,
                    parent,
                    false
                )
            )
            else -> AllDividerVh(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_all_divider,
                    parent,
                    false
                )
            )
        }


    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = events[position]
        when (getItemViewType(position)) {
            ALL_EVENT_TYPE -> (holder as AllEventsVh).bind(item as AllEventsModel)
            ALL_LESSON_TYPE -> (holder as AllLessonsVh).bind(item as AllLessonsModel)
            ALL_DIVIDER_TYPE -> (holder as AllDividerVh).bind(item.date)
        }

    }
}

class AllEventsVh(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(event: AllEventsModel) {
        itemView.item_all_event_tv_time.text = event.date
        itemView.item_all_event_tv_name.text = event.name
        itemView.item_all_event_tv_address.text = event.address
    }
}

class AllLessonsVh(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(event: AllLessonsModel) {
        itemView.item_all_lesson_tv_time.text = event.date
        itemView.item_all_lesson_tv_name.text = event.name
        itemView.item_all_lesson_tv_address.text = event.address
        itemView.item_all_lesson_cl_background.background =
            ContextCompat.getDrawable(itemView.context, getLessonBackgroundByGroup(event.groupId))
    }
}

class AllDividerVh(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(date: String) {
        itemView.item_all_divider_tv_date.text = date
    }
}