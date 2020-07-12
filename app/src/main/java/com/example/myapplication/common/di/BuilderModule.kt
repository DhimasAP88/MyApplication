package com.example.myapplication.common.di

import com.example.myapplication.detail.DetailActivity
import com.example.myapplication.detail.DetailActivityModule
import com.example.myapplication.home.HomeActivity
import com.example.myapplication.home.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {
    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [(DetailActivityModule::class)])
    abstract fun bindDetailActivity(): DetailActivity
}