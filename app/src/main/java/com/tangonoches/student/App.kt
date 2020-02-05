package com.tangonoches.student

import android.app.Application
import com.tangonoches.student.di.ComponentsHolder
import com.tangonoches.student.di.components.DaggerMainComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentsHolder.mainComponent = DaggerMainComponent.builder().context(this).build()
    }
}