package com.tangonoches.student.presentation.loginScan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.tangonoches.student.R
import com.tangonoches.student.presentation.base.BaseVmActivity
import com.tangonoches.student.presentation.login.SCAN_RESULT_ID
import com.tangonoches.student.presentation.login.SCAN_SUCCESS_RESULT
import kotlinx.android.synthetic.main.activity_login_scan.*
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView


const val CAMERA_PERMISSIONS_REQUEST = 1234

class LoginScanActivity : BaseVmActivity<LoginScanVm>(), ZBarScannerView.ResultHandler {
    override fun getVmClass(): Class<LoginScanVm> = LoginScanVm::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_scan)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                //request
                requestPermissions(
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSIONS_REQUEST
                )
            } else {
                //granted
                runCamera()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSIONS_REQUEST) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                runCamera()
            } else {
                Toast.makeText(
                    this,
                    "Необходимы разрешение, что бы запустить сканирование",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun runCamera() {
        vm.permissionsGranted = true

    }

    public override fun onResume() {
        super.onResume()
        if (vm.permissionsGranted) {
            activity_login_zbar.setResultHandler(this) // Register ourselves as a handler for scan results.
            activity_login_zbar.startCamera()          // Start camera on resume
        }
    }

    public override fun onPause() {
        super.onPause()
        if (vm.permissionsGranted) {
            activity_login_zbar.stopCamera()
        }// Stop camera on pause
    }


    override fun handleResult(rawResult: Result?) {
        var result = rawResult?.contents + rawResult?.barcodeFormat?.name
//        Toast.makeText(this, result, Toast.LENGTH_LONG).show()

        // If you would like to resume scanning, call this method below:
//        activity_login_zbar.resumeCameraPreview(this)
        try {
            val barcodeContent = rawResult?.contents?.toLong() ?: -1
            if (barcodeContent > 0) {
                finishWithResult(barcodeContent)
            } else {
                Toast.makeText(
                    this,
                    "Неверный формат, попробуйте еще",
                    Toast.LENGTH_LONG
                ).show()
                activity_login_zbar.resumeCameraPreview(this)
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(
                this,
                "Неверный формат, попробуйте еще",
                Toast.LENGTH_LONG
            ).show()
            activity_login_zbar.resumeCameraPreview(this)
        }
    }

    private fun finishWithResult(id: Long){
        val resultIntent = Intent()
        resultIntent.putExtra(SCAN_RESULT_ID, id)
        setResult(SCAN_SUCCESS_RESULT, resultIntent)
        finish()
    }
}