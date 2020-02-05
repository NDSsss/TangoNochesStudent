package com.tangonoches.student.di.modules

import com.tangonoches.student.domain.datasources.main.IMainDatasource
import com.tangonoches.student.domain.datasources.main.MainDataSource
import com.tangonoches.student.domain.services.IMainService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Provides
    @Singleton
    fun provideMainDatasource(mainService: IMainService): IMainDatasource =
        MainDataSource(mainService)
}