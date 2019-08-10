package com.example.myappnetwork.di

import com.example.myappdata.account.repository.AccountService
import com.example.myappdata.transaction.repository.TransactionService
import com.example.myappkit.constant.TagInjectConstant
import com.example.myappnetwork.rest.transaction.TransactionServiceImpl
import com.example.myappnetwork.extension.defaultBuilder
import com.example.myappnetwork.rest.account.AccountServiceImpl
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class MyAppNetworkModule {

    @Provides
    @Singleton
    @Named(TagInjectConstant.RETROFIT_MYAPP)
    fun provideRetrofit(
        @Named(TagInjectConstant.OKHTTP_MYAPP) okHttpClient: OkHttpClient,
        @Named(TagInjectConstant.APP_INIT_URL_MYAPP) baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Named(TagInjectConstant.OKHTTP_MYAPP)
    fun provideOkHttpClient(
        @Named(TagInjectConstant.CONNECTIVITY_INTERCEPTOR) connectivityInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .defaultBuilder()
            .addInterceptor(connectivityInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideTransactionService(
        @Named(TagInjectConstant.RETROFIT_MYAPP) retrofit: Retrofit): TransactionService {
        return TransactionServiceImpl(retrofit)
    }

    @Provides
    @Singleton
    fun provideAccountService(
        @Named(TagInjectConstant.RETROFIT_MYAPP) retrofit: Retrofit): AccountService
            = AccountServiceImpl(retrofit)
}
