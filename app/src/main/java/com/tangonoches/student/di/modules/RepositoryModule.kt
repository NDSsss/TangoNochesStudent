package com.tangonoches.student.di.modules

import com.tangonoches.student.domain.datasources.main.IMainDatasource
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.repositories.main.IMainRepository
import com.tangonoches.student.domain.repositories.main.IUpdateFcmTokenUseCase
import com.tangonoches.student.domain.repositories.main.MainRepository
import com.tangonoches.student.domain.repositories.main.UpdateFcmTokenUseCase
import com.tangonoches.student.domain.services.IFcmTokenApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(
        mainDataSource: IMainDatasource,
        prefsStorage: IPrefsStorage,
        updateFcmTokenUseCase: IUpdateFcmTokenUseCase
    ): IMainRepository =
        MainRepository(mainDataSource, prefsStorage, updateFcmTokenUseCase)

    @Provides
    @Singleton
    fun provideIUpdateFcmTokenUseCase(
        service: IFcmTokenApiService,
        prefsStorage: IPrefsStorage
    ): IUpdateFcmTokenUseCase =
        UpdateFcmTokenUseCase(
            updateIFcmTokenApiService = service,
            prefsStorage = prefsStorage
        )
}