package com.tangonoches.student.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.jakewharton.rxbinding2.view.clicks
import com.tangonoches.student.R
import com.tangonoches.student.presentation.base.BaseVmActivity
import com.tangonoches.student.presentation.loginScan.LoginScanActivity
import com.tangonoches.student.presentation.main.MainActivity
import kotlinx.android.synthetic.main.act_login.*

const val SCAN_REQUEST_CODE = 1
const val SCAN_SUCCESS_RESULT = 1
const val SCAN_RESULT_ID = "SCAN_RESULT_ID"

class LoginActivity : BaseVmActivity<LoginVm>() {
    override fun getVmClass(): Class<LoginVm> = LoginVm::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_login)
        act_login_scan_iv.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    LoginScanActivity::class.java
                ), SCAN_REQUEST_CODE
            )
        }
    }

    override fun createVmBinds() {
        super.createVmBinds()
        vmBinds.addAll(
            vm.loginSuccess.subscribe {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },
            vm.loginError.subscribe {
                act_login_id_til.error = it
            },
            act_login_login_btn.clicks().subscribe {
                vm.loginAction.accept(act_login_id_et.text.toString() to act_login_password_et.text.toString())
            }
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SCAN_REQUEST_CODE && resultCode == SCAN_SUCCESS_RESULT) {
            val dataId = data?.getLongExtra(SCAN_RESULT_ID, -1)
            if (dataId != null && dataId > 0) {
//                vm.loginAction.accept(dataId.toString())
            } else {
                Toast.makeText(
                    this,
                    "Повторите сканирование, или введите ID в ручную",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}