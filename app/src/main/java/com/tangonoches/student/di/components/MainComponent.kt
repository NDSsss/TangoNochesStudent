package com.tangonoches.student.di.components

import android.content.Context
import com.tangonoches.student.di.VmFactoryWrapper
import com.tangonoches.student.di.modules.*
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.repositories.main.IUpdateFcmTokenUseCase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetModule::class,
        ServicesModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        PrefsModule::class,
        VmModule::class,
        UtilsModule::class
    ]
)
@Singleton
interface MainComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): MainComponent
    }

    fun inject(vmFactoryWrapper: VmFactoryWrapper)
    fun providePrefsStorage(): IPrefsStorage
    fun provideIUpdateFcmTokenUseCase(): IUpdateFcmTokenUseCase
}