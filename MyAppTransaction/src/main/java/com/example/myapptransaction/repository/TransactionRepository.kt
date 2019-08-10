package com.example.myapptransaction.repository

import io.reactivex.Single

interface TransactionRepository {

    fun test(
        firstNumber: String,
        secondNumber: String): Single<String>
}