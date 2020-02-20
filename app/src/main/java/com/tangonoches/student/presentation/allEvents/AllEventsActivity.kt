package com.tangonoches.student.presentation.allEvents

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tangonoches.student.R
import com.tangonoches.student.presentation.base.BaseVmActivity
import kotlinx.android.synthetic.main.act_all_lessons.*

class AllEventsActivity : BaseVmActivity<AllEventsActivityVm>() {
    override fun getVmClass(): Class<AllEventsActivityVm> = AllEventsActivityVm::class.java

    private var lessonsAdapter: AllEventsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_all_lessons)
        setSupportActionBar(act_all_lessons_toolbar)
        act_all_lessons_toolbar.setNavigationOnClickListener { this.finish() }
        setTitle("Мероприятия")
        initRecyclers()
    }

    private fun initRecyclers() {
        act_all_lessons_rv.layoutManager = LinearLayoutManager(this)
            .apply { this.orientation = LinearLayoutManager.VERTICAL }
        lessonsAdapter = AllEventsAdapter()
        act_all_lessons_rv.adapter = lessonsAdapter
    }

    override fun createVmBinds() {
        super.createVmBinds()
        vmBinds.addAll(
            vm.lessonsRelay.subscribe {
                lessonsAdapter?.events = it
            }
        )
        vm.loadDataEvent.accept(Unit)
    }
}
