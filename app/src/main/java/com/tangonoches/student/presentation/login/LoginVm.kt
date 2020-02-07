package com.tangonoches.student.presentation.login

import com.jakewharton.rxrelay2.BehaviorRelay
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.presentation.base.BaseVm
import javax.inject.Inject

class LoginVm @Inject constructor(
    val prefsStorage: IPrefsStorage
) : BaseVm() {
    val loginAction = BehaviorRelay.create<String>()

    val loginSuccess = BehaviorRelay.create<Unit>()
    val loginError = BehaviorRelay.create<String>()

    override fun viewCreated() {
        super.viewCreated()
        if(prefsStorage.barcodeId > 0){
            loginSuccess.accept(Unit)
        }
    }

    override fun createBinds() {
        super.createBinds()
        binds.add(loginAction.subscribe{
            try {
                val id = it.toLong()
                prefsStorage.barcodeId = id
                loginSuccess.accept(Unit)
            } catch (e:NumberFormatException){
                loginError.accept("Не правильный формат ID")
            }
        })
    }
}