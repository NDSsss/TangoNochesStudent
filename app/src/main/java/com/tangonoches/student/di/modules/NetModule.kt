package com.tangonoches.student.di.modules

import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideOkkHttpClient(): OkHttpClient {
        Log.d("APP_TAG","provideOkkHttpClient")
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
        return clientBuilder.build()
    }


    @Provides
    @Singleton
    fun providesRetrofit(okkClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://ndssss.beget.tech/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okkClient)
            .build()

}