package com.example.myappdata.transaction

import com.example.myappdata.transaction.source.TransactionDataSource
import com.example.myapptransaction.model.DetailComment
import com.example.myapptransaction.repository.TransactionRepository
import io.reactivex.Single
import javax.inject.Inject

class TransactionRepositorySource
@Inject constructor(private val factory: TransactionDataSource.Factory) : TransactionRepository {

    override fun test(firstNumber: String, secondNumber: String): Single<List<Int>> {
        return factory.network().test(firstNumber, secondNumber)
    }

    override fun getDetail(id: String): Single<DetailComment> {
        return factory.network().getDetail(id)
    }

}