package com.example.myapplication.common.network

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil(private val context: Context) {
    fun isOnline(): Boolean {
        val netInfo = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}