package com.example.myappnetwork.rest.transaction

import com.example.myappdata.transaction.entity.DetailCommentEntity
import com.example.myappdata.transaction.repository.TransactionService
import io.reactivex.Single
import retrofit2.Retrofit

class TransactionServiceImpl(
    private val retrofit: Retrofit) : TransactionService {

    private val service by lazy { retrofit.create(TransactionApi::class.java) }

    override fun test(firstNumber: String, secondNumber: String): Single<List<Int>> {
        return service.test(url = "https://hacker-news.firebaseio.com/v0/topstories.json")
    }

    override fun getDetail(id: String): Single<DetailCommentEntity> {
        return service.getDetail(url = "https://hacker-news.firebaseio.com/v0/item/$id.json?print=pretty")
    }
}