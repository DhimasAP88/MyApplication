package com.example.myappnetwork.rest.transaction

import com.example.myappdata.transaction.entity.DetailCommentEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface TransactionApi {

    @GET
    fun test(@Url() url: String): Single<List<Int>>

    @GET
    fun getDetail(@Url() url: String): Single<DetailCommentEntity>
}