package com.example.myappnetwork.rest.transaction

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface TransactionApi {

    @GET
    fun test(@Url() url: String): Single<String>
}