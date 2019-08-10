package com.example.myappdata.account.entity

import com.example.myappaccount.model.AccountModel

data class AccountModelEntity(var firstname: String? = "") {
    fun create() : AccountModel{
        val account = AccountModel(
            firstname = firstname.orEmpty()
        )

        return account
    }
}