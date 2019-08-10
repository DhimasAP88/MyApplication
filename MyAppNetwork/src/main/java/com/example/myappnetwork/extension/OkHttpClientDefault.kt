package com.example.myappnetwork.extension

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

internal fun OkHttpClient.Builder.defaultBuilder() : OkHttpClient.Builder {
    addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    connectTimeout(60, TimeUnit.SECONDS)
    readTimeout(60, TimeUnit.SECONDS)
    writeTimeout(60, TimeUnit.SECONDS)
    return this
}