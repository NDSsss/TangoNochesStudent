package com.tangonoches.student.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.tangonoches.student.R
import com.tangonoches.student.presentation.base.BaseVmActivity
import com.tangonoches.student.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVmActivity<MainActivityVm>() {
    override fun getVmClass(): Class<MainActivityVm> = MainActivityVm::class.java

    private var lessonsAdapter: LessonsAdapter? = null
    private var eventsAdapter: EventsAdapter? = null
    private var ticketsAdapter: TicketsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(act_main_toolbar)
        initRecyclers()
    }

    private fun initRecyclers() {
        act_main_rv_lessons.layoutManager = LinearLayoutManager(this)
            .apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        lessonsAdapter = LessonsAdapter()
        act_main_rv_lessons.adapter = lessonsAdapter

        act_main_rv_tickets.layoutManager = LinearLayoutManager(this)
            .apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        ticketsAdapter = TicketsAdapter()
        act_main_rv_tickets.adapter = ticketsAdapter

        act_main_rv_events.layoutManager = LinearLayoutManager(this)
            .apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        eventsAdapter = EventsAdapter()
        act_main_rv_events.adapter = eventsAdapter
    }

    override fun createVmBinds() {
        super.createVmBinds()
        vmBinds.addAll(
            vm.lessonsRelay.subscribe {
                lessonsAdapter?.lessons = it
            },
            vm.eventsRelay.subscribe {
                eventsAdapter?.events = it
            },
            vm.ticketsRelay.subscribe {
                ticketsAdapter?.tickets = it
            }
        )
        vm.loadDataEvent.accept(Unit)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.menu_main_qr -> {
                vm.prefsStorage.barcodeId = 0
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
