package com.tangonoches.student.presentation.allEvents

import android.util.Log
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.PublishRelay
import com.tangonoches.student.data.models.BaseAllListsItem
import com.tangonoches.student.data.models.Event
import com.tangonoches.student.data.models.Lesson
import com.tangonoches.student.domain.repositories.main.IMainRepository
import com.tangonoches.student.presentation.base.BaseVm
import javax.inject.Inject

class AllEventsActivityVm @Inject constructor(
    private val mainRepository: IMainRepository
) : BaseVm() {

    val lessonsRelay = BehaviorRelay.create<List<BaseAllListsItem>>()

    val loadDataEvent = PublishRelay.create<Unit>()

    override fun createBinds() {
        Log.d("APP_TAG", "MainActivityVm createBinds")
        binds.addAll(
            loadDataEvent.subscribe {
                loadData()
            }
        )
    }

    private fun loadData() {
        binds.add(
            mainRepository.getAllDividedEventsList().subscribe(
                { lessons ->
                    lessonsRelay.accept(lessons)
                },
                {
                    Log.d("APP_TAG", it.localizedMessage)
                })
        )
    }
}