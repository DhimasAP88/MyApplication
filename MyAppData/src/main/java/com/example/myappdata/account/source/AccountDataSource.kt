package com.example.myappdata.account.source

import com.example.myappaccount.model.AccountModel
import com.example.myappaccount.repository.AccountRepository
import com.example.myappdata.account.repository.AccountService
import dagger.Lazy
import io.reactivex.Single
import javax.inject.Inject

interface AccountDataSource: AccountRepository {

    class Factory
    @Inject constructor(private val network: Lazy<Network>
    ) {
        fun network(): Network = network.get()
    }

    class Network
    @Inject constructor(private val service: AccountService): AccountDataSource{
        override fun getAccount(): Single<AccountModel> {
            return service.getAccount().map { it.create() }
        }

    }
}