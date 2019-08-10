package com.example.myapplication.common.di

import android.app.Application
import com.example.myappkit.constant.TagInjectConstant
import com.example.myapplication.BuildConfig
import com.example.myapplication.common.network.ConnectivityInterceptor
import com.example.myapplication.common.network.NetworkUtil
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Named(TagInjectConstant.SCHEDULER_EXECUTION)
    fun provideExecutionScheduler() = Schedulers.io()

    @Provides
    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION)
    fun providePostExecutionScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    @Named(TagInjectConstant.APP_INIT_URL_MYAPP)
    fun provideAppInitUrl() = BuildConfig.base_url

    @Provides
    @Singleton
    fun provideNetworkUtil(app: Application): NetworkUtil {
        return NetworkUtil(app.applicationContext)
    }

    @Provides
    @Singleton
    @Named(TagInjectConstant.CONNECTIVITY_INTERCEPTOR)
    fun provideConnectivityInterceptor(networkUtil: NetworkUtil)
            : Interceptor {
        return ConnectivityInterceptor(networkUtil, "Silakan cek koneksi internat Anda.", "Terjadi kesalahan.")
    }

}