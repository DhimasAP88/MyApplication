package com.example.myappdata.account.repository

import com.example.myappdata.account.entity.AccountModelEntity
import io.reactivex.Single

interface AccountService {
    fun getAccount(): Single<AccountModelEntity>
}