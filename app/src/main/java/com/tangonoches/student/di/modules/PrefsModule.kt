package com.tangonoches.student.di.modules

import android.content.Context
import com.tangonoches.student.domain.datasources.prefs.IPrefsStorage
import com.tangonoches.student.domain.datasources.prefs.PrefsStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PrefsModule {
    @Provides
    @Singleton
    fun providePrefsStorage(context: Context): IPrefsStorage =
        PrefsStorage(context)
}