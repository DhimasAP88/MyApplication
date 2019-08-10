package com.example.myappnetwork.rest.account

import com.example.myappdata.account.entity.AccountModelEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface AccountApi {

    @GET
    fun getAccount(@Url url: String): Single<AccountModelEntity>
}