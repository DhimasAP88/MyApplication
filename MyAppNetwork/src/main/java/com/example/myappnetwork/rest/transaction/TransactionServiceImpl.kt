package com.example.myappnetwork.rest.transaction

import com.example.myappdata.transaction.repository.TransactionService
import io.reactivex.Single
import retrofit2.Retrofit

class TransactionServiceImpl(
    private val retrofit: Retrofit) : TransactionService {

    private val service by lazy { retrofit.create(TransactionApi::class.java) }

    override fun test(firstNumber: String, secondNumber: String): Single<String> {
        return service.test(url = "https://api.mathjs.org/v4/?expr=$firstNumber%2B$secondNumber")
    }
}