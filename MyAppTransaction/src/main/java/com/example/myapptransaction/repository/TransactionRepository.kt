package com.example.myapptransaction.repository

import com.example.myapptransaction.model.DetailComment
import io.reactivex.Single

interface TransactionRepository {

    fun test(
        firstNumber: String,
        secondNumber: String): Single<List<Int>>

    fun getDetail(id: String): Single<DetailComment>
}