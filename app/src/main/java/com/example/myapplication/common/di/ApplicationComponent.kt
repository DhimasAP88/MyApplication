package com.example.myapplication.common.di

import android.app.Application
import com.example.myappdata.di.MyAppDataModule
import com.example.myapplication.MyApplication
import com.example.myappnetwork.di.MyAppNetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (BuilderModule::class),
        (ApplicationModule::class),
        (MyAppNetworkModule::class),
        (MyAppDataModule::class)
    ]
)

interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MyApplication)
}