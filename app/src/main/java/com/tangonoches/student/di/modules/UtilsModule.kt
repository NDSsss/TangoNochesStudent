package com.tangonoches.student.di.modules

import com.tangonoches.student.utils.QrCodeGenerator
import com.tangonoches.student.utils.ZxingQrCodeGenerator
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {
    @Provides
    fun provideQrUtils(): QrCodeGenerator = ZxingQrCodeGenerator()
}