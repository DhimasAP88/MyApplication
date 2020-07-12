package com.example.myapplication.detail

import android.arch.lifecycle.ViewModelProviders
import com.example.myappdata.transaction.source.TransactionDataSource
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule {
    @Provides
    fun provideViewModel(activity: DetailActivity, factory: DetailViewModel.Factory): DetailViewModelType {
        return ViewModelProviders.of(activity, factory).get(DetailViewModel::class.java)
    }
}