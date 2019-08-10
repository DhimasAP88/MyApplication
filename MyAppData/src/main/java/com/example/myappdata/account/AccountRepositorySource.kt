package com.example.myappdata.account

import com.example.myappaccount.model.AccountModel
import com.example.myappaccount.repository.AccountRepository
import com.example.myappdata.account.source.AccountDataSource
import io.reactivex.Single
import javax.inject.Inject

class AccountRepositorySource
@Inject constructor(private val factory: AccountDataSource.Factory) : AccountRepository{
    override fun getAccount(): Single<AccountModel> {
        return factory.network().getAccount()
    }
}