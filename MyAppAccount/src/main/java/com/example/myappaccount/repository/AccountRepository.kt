package com.example.myappaccount.repository

import com.example.myappaccount.model.AccountModel
import io.reactivex.Single

interface AccountRepository {
    fun getAccount(): Single<AccountModel>
}