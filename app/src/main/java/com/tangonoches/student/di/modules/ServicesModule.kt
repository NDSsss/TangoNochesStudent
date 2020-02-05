package com.tangonoches.student.di.modules

import com.tangonoches.student.domain.services.IMainService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
class ServicesModule {
    @Provides
    @Singleton
    fun provideMainService(retrofit: Retrofit):IMainService =
        retrofit.create(IMainService::class.java)
}