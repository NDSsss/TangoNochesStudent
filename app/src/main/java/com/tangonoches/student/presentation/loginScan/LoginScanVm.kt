package com.tangonoches.student.presentation.loginScan

import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.presentation.base.BaseVm
import javax.inject.Inject

class LoginScanVm @Inject constructor(
    val prefsStorage: IPrefsStorage
) : BaseVm() {

    var permissionsGranted = false

}