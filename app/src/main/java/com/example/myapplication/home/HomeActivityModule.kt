package com.example.myapplication.home

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {
    @Provides
    fun provideViewModel(activity: HomeActivity, factory: HomeActivityViewModel.Factory): HomeActivityViewModelType {
        return ViewModelProviders.of(activity, factory).get(HomeActivityViewModel::class.java)
    }
}