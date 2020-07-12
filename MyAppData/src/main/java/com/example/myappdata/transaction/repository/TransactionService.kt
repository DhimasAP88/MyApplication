package com.example.myappdata.transaction.repository

import com.example.myappdata.transaction.entity.DetailCommentEntity
import io.reactivex.Single

interface TransactionService {
    fun test(
        firstNumber: String,
        secondNumber: String
    ): Single<List<Int>>

    fun getDetail(id: String): Single<DetailCommentEntity>
}