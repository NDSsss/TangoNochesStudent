package com.tangonoches.student.presentation.login

import android.util.Log
import com.jakewharton.rxrelay2.BehaviorRelay
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.repositories.main.IMainRepository
import com.tangonoches.student.presentation.base.BaseVm
import javax.inject.Inject

class LoginVm @Inject constructor(
    val prefsStorage: IPrefsStorage,
    val mainRepository: IMainRepository

) : BaseVm() {
    val loginAction = BehaviorRelay.create<Pair<String,String>>()

    val loginSuccess = BehaviorRelay.create<Unit>()
    val loginError = BehaviorRelay.create<String>()

    val isLoading = BehaviorRelay.create<Boolean>()

    override fun viewCreated() {
        super.viewCreated()
        if(prefsStorage.barcodeId > 0){
            loginSuccess.accept(Unit)
        }
    }

    override fun createBinds() {
        super.createBinds()
        binds.add(loginAction.subscribe{(login, password)->
//            try {
//                val id = it.toLong()
//                prefsStorage.barcodeId = id
//                loginSuccess.accept(Unit)
//            } catch (e:NumberFormatException){
//                loginError.accept("Не правильный формат ID")
//            }
            isLoading.accept(true)
            binds.add(
                mainRepository.login(login, password)
                    .subscribe(
                        {
                            Log.d("APP_TAG", "mainRepository.login onSuccess");
                            isLoading.accept(false)
                            loginSuccess.accept(Unit)
                        },{
                            Log.d("APP_TAG", "mainRepository.login onError: ${it.message}");
                            isLoading.accept(false)
                        }
                    )
            )
        })
    }
}