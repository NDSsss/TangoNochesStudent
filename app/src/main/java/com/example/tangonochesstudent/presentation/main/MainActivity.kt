package com.example.tangonochesstudent.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tangonochesstudent.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_qr.view.*

class MainActivity : AppCompatActivity() {

    lateinit var vm: MainActivityVm

    private val binds = CompositeDisposable()

    private var lessonsAdapter: LessonsAdapter? = null
    private var eventsAdapter: EventsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProviders.of(this).get(MainActivityVm::class.java)
        setSupportActionBar(act_main_toolbar)
        initRecyclers()
        initBinds()
        act_main_ticket_lessons_left.setOnClickListener {
             val currLeft = act_main_ticket_lessons_left.text.toString().toInt()
            val nextLeft = if(currLeft>1){
                currLeft -1
            } else{
                5
            }
            act_main_ticket_lessons_left.text = nextLeft.toString()
            initTicketBg(nextLeft)
        }
    }

    private fun initRecyclers() {
        act_main_rv_lessons.layoutManager = LinearLayoutManager(this)
            .apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        lessonsAdapter = LessonsAdapter()
        act_main_rv_lessons.adapter = lessonsAdapter

        act_main_rv_events.layoutManager = LinearLayoutManager(this)
            .apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        eventsAdapter = EventsAdapter()
        act_main_rv_events.adapter = eventsAdapter
    }

    private fun initBinds() {
        binds.addAll(
            vm.lessonsRelay.subscribe {
                lessonsAdapter?.lessons = it
            },
            vm.eventsRelay.subscribe {
                eventsAdapter?.events = it
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.menu_main_qr -> {
                val dialog = BottomSheetDialog(this)
                val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_qr, null, false)
                dialogView.dialog_qr_btn_close.setOnClickListener { dialog.dismiss() }
                dialog.setContentView(dialogView)
                dialog.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun initTicketBg(left: Int) {
        act_main_ticket.setImageDrawable(
            resources.getDrawable(
                when {
                    left >= 4 -> R.drawable.ic_bg_ticket_green
                    left in 2..3 -> R.drawable.ic_bg_ticket_orange
                    left < 2 -> R.drawable.ic_bg_ticket_red
                    else -> R.drawable.ic_bg_ticket_green
                }
            )
        )

    }
}
