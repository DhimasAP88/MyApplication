package com.example.myappnetwork.rest.account

import com.example.myappdata.account.entity.AccountModelEntity
import com.example.myappdata.account.repository.AccountService
import io.reactivex.Single
import retrofit2.Retrofit

class AccountServiceImpl(private val retrofit: Retrofit): AccountService {

    private val accountService by lazy { retrofit.create(AccountApi::class.java) }

    override fun getAccount(): Single<AccountModelEntity> {
        return accountService.getAccount(url = "?expr=2+3s")
    }

}