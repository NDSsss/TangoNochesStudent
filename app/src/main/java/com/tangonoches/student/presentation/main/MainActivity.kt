package com.tangonoches.student.presentation.main

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jakewharton.rxbinding2.view.clicks
import com.tangonoches.student.R
import com.tangonoches.student.presentation.allEvents.AllEventsActivity
import com.tangonoches.student.presentation.allLessons.AllLessonsActivity
import com.tangonoches.student.presentation.base.BaseVmActivity
import com.tangonoches.student.presentation.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_logout.view.*
import kotlinx.android.synthetic.main.dialog_qr.view.*

class MainActivity : BaseVmActivity<MainActivityVm>() {
    override fun getVmClass(): Class<MainActivityVm> = MainActivityVm::class.java

    private var lessonsAdapter: LessonsAdapter? = null
    private var eventsAdapter: EventsAdapter? = null
    private var ticketsAdapter: TicketsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(act_main_toolbar)
        initSwipeToRefresh()
        initRecyclers()
    }

    private fun initSwipeToRefresh() {
        act_main_swtr.setOnRefreshListener { vm.refreshDataEvent.accept(Unit) }
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
            },
            vm.refreshingRelay.subscribe {
                act_main_swtr.isRefreshing = it
            },
            act_main_btn_show_qr.clicks().subscribe {
                vm.showBarcodeEvent.accept(Unit)
            },
            vm.barcodeRelay.subscribe {
                openBarcode(it)
            },
            act_main_tv_lesson_block_all.clicks().subscribe {
                openAllLessons()
            },
            act_main_tv_events_block_all.clicks().subscribe {
                openAllEvents()
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
            R.id.menu_main_logout -> {
                val dialogBuilder = AlertDialog.Builder(this)
                val dialogContent =
                    LayoutInflater.from(this).inflate(R.layout.dialog_logout, null, false)
                dialogBuilder.setView(dialogContent)
                dialogContent.dialog_logout_confirm_btn.setOnClickListener { openLogin() }
                val dialog = dialogBuilder.show()
                dialogContent.dialog_logout_decline_btn.setOnClickListener { dialog.dismiss() }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun openLogin() {
        vm.prefsStorage.barcodeId = 0
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun openBarcode(barcodeImage: Bitmap) {
        val dialog = BottomSheetDialog(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_qr, null, false)
        dialogView.dialog_qr_btn_close.setOnClickListener { dialog.dismiss() }
        dialogView.dialog_qr_iv_qr.setImageBitmap(barcodeImage)
        dialog.setContentView(dialogView)
        dialog.show()
    }

    private fun openAllLessons() {
        startActivity(Intent(this, AllLessonsActivity::class.java))
    }

    private fun openAllEvents() {
        startActivity(Intent(this, AllEventsActivity::class.java))
    }
}
