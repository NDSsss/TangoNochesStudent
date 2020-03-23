package com.tangonoches.student.data.models

import java.text.SimpleDateFormat
import java.util.*


open class BaseAllListsItem(val date: String) {
    override fun toString(): String {
        return date
    }
}

class AllEventsModel(date: String, val name: String, val address: String, val rawStartDate: Date) :
    BaseAllListsItem(date)

class AllLessonsModel(date: String, val name: String, val address: String, val rawStartDate: Date, val groupId:Long) :
    BaseAllListsItem(date)

class AllItemsDividerModel(date: String) : BaseAllListsItem(date)

fun List<AllEventsModel>.toAllDividedEventsList(): List<BaseAllListsItem> {
    val resultList = arrayListOf<BaseAllListsItem>()
    for (i in this.indices) {
        when (i) {
            0 -> {
                resultList.add(AllItemsDividerModel(this[i].rawStartDate.toAllItemsDividerFormat()))
                resultList.add(this[i])
            }
            else -> {
                val previousItem = this[i - 1]
                val currentItem = this[i]
                if (currentItem.rawStartDate.dayIsNotEqual(previousItem.rawStartDate)) {
                    resultList.add(AllItemsDividerModel(this[i].rawStartDate.toAllItemsDividerFormat()))
                }
                resultList.add(this[i])
            }
        }
    }
    return resultList
}

fun Date.dayIsNotEqual(secondDate: Date): Boolean {

    val cal1 = Calendar.getInstance()
    val cal2 = Calendar.getInstance()
    cal1.time = this
    cal2.time = secondDate
    return cal1.get(Calendar.DAY_OF_YEAR) != cal2.get(Calendar.DAY_OF_YEAR)
}

fun Date.toAllItemsDividerFormat(): String {
    val wantedFormat = SimpleDateFormat("dd MMMM, EEEE")
    return wantedFormat.format(this)
}

fun List<AllLessonsModel>.toAllDividedLessonsList(): List<BaseAllListsItem> {
    val resultList = arrayListOf<BaseAllListsItem>()
    for (i in this.indices) {
        when (i) {
            0 -> {
                resultList.add(AllItemsDividerModel(this[i].rawStartDate.toAllItemsDividerFormat()))
                resultList.add(this[i])
            }
            else -> {
                val previousItem = this[i - 1]
                val currentItem = this[i]
                if (currentItem.rawStartDate.dayIsNotEqual(previousItem.rawStartDate)) {
                    resultList.add(AllItemsDividerModel(this[i].rawStartDate.toAllItemsDividerFormat()))
                }
                resultList.add(this[i])
            }
        }
    }
    return resultList
}

