package com.tangonoches.student.presentation.login

import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.presentation.base.BaseVm
import javax.inject.Inject

class LoginVm @Inject constructor(
    val prefsStorage: IPrefsStorage
) : BaseVm() {

    var permissionsGranted = false

}