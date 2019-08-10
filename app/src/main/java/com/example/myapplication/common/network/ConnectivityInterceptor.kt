package com.example.myapplication.common.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.lang.Exception

class ConnectivityInterceptor(private val networkUtil: NetworkUtil,
                              private val noConnectionMessage: String,
                              private val genericError: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        if (!networkUtil.isOnline()) {
            Log.e("Error", noConnectionMessage)
            throw Exception()
        } else {
            val originResponse: Response = chain!!.proceed(chain.request())
            when (originResponse.code()) {
                504 -> throw Exception()
                else -> return originResponse
            }
        }
    }
}