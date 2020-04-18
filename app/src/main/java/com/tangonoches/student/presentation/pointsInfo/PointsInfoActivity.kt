package com.tangonoches.student.presentation.pointsInfo

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import com.tangonoches.student.R
import com.tangonoches.student.presentation.base.BaseVmActivity
import kotlinx.android.synthetic.main.act_point_info.*


class PointsInfoActivity : BaseVmActivity<PointsInfoActivityVm>() {
    override fun getVmClass(): Class<PointsInfoActivityVm> = PointsInfoActivityVm::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_point_info)
        setSupportActionBar(act_points_info_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        act_points_ifo.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }
}