package com.tangonoches.student.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tangonoches.student.di.ComponentsHolder
import com.tangonoches.student.di.VmFactoryWrapper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseVmActivity<VM : BaseVm> : AppCompatActivity() {

    protected val vmFactoryWrapper = VmFactoryWrapper()

    protected val vm: VM by lazy {
        ViewModelProviders
            .of(this, vmFactoryWrapper.factory)
            .get(getVmClass())
    }

    protected val vmBinds: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentsHolder.mainComponent.inject(vmFactoryWrapper)
        super.onCreate(savedInstanceState)
        vm.viewCreated()
    }

    open protected fun createVmBinds() {

    }

    override fun onResume() {
        super.onResume()
        createVmBinds()
    }

    override fun onPause() {
        vmBinds.clear()
        super.onPause()
    }

    protected fun getVmFactory(): ViewModelProvider.Factory = vmFactoryWrapper.factory

    protected abstract fun getVmClass(): Class<VM>
}