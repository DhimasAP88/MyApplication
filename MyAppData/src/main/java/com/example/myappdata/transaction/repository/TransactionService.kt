package com.example.myappdata.transaction.repository

import io.reactivex.Single

interface TransactionService {
    fun test(
        firstNumber: String,
        secondNumber: String
    ): Single<String>
}