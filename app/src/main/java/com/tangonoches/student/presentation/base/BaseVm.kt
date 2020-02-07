package com.tangonoches.student.presentation.base

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseVm : ViewModel() {
    protected val binds = CompositeDisposable()

    open public fun viewCreated(){
        Log.d("APP_TAG", "BaseVm viewCreated")
        createBinds()
    }

    open protected fun createBinds(){
        Log.d("APP_TAG", "BaseVm createBinds")
    }

    override fun onCleared() {
        binds.clear()
        super.onCleared()
    }
}