package com.tangonoches.student.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tangonoches.student.di.vm.VmFactory
import com.tangonoches.student.di.vm.VmKeyName
import com.tangonoches.student.presentation.allEvents.AllEventsActivityVm
import com.tangonoches.student.presentation.allLessons.AllLessonsActivityVm
import com.tangonoches.student.presentation.login.LoginVm
import com.tangonoches.student.presentation.loginScan.LoginScanVm
import com.tangonoches.student.presentation.main.MainActivityVm
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface VmModule {

    @Binds
    @IntoMap
    @VmKeyName(MainActivityVm::class)
    fun bindMainAvtivityVm(viewModel: MainActivityVm): ViewModel

    @Binds
    @IntoMap
    @VmKeyName(AllLessonsActivityVm::class)
    fun bindAllLessonsActivityVm(viewModel: AllLessonsActivityVm): ViewModel

    @Binds
    @IntoMap
    @VmKeyName(AllEventsActivityVm::class)
    fun bindAllEventsActivityVm(viewModel: AllEventsActivityVm): ViewModel

    @Binds
    @IntoMap
    @VmKeyName(LoginScanVm::class)
    fun bindLoginScanAvtivityVm(viewModel: LoginScanVm): ViewModel

    @Binds
    @IntoMap
    @VmKeyName(LoginVm::class)
    fun bindLoginAvtivityVm(viewModel: LoginVm): ViewModel

    @Binds
    @Singleton
    fun provideViewModelFactory(vmFactory: VmFactory): ViewModelProvider.Factory

}