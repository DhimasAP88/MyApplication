package com.example.myappdata.transaction.source

import com.example.myappdata.transaction.repository.TransactionService
import com.example.myapptransaction.repository.TransactionRepository
import io.reactivex.Single
import javax.inject.Inject
import dagger.Lazy

interface TransactionDataSource : TransactionRepository {

    class Factory
    @Inject constructor(private val network: Lazy<Network>) {
        fun network(): Network = network.get()
    }

    class Network
    @Inject constructor(private val service: TransactionService) : TransactionDataSource {

        override fun test(firstNumber: String, secondNumber: String): Single<String> {
            return service.test(firstNumber, secondNumber).map { it}
        }

    }
}