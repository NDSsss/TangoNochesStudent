package com.tangonoches.student.di.modules

import com.tangonoches.student.domain.datasources.main.IMainDatasource
import com.tangonoches.student.domain.repositories.main.IMainRepository
import com.tangonoches.student.domain.repositories.main.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(mainDataSource: IMainDatasource): IMainRepository =
        MainRepository(mainDataSource)
}