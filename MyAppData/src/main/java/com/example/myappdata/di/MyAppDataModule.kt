package com.example.myappdata.di

import com.example.myappaccount.repository.AccountRepository
import com.example.myappdata.account.AccountRepositorySource
import com.example.myappdata.transaction.TransactionRepositorySource
import com.example.myapptransaction.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyAppDataModule {

    @Provides
    @Singleton
    fun provideTransactionRepository(transactionRepositorySource: TransactionRepositorySource)
        : TransactionRepository = transactionRepositorySource

    @Provides
    @Singleton
    fun provideAccountRepository(accountRepositorySource: AccountRepositorySource)
        : AccountRepository = accountRepositorySource
}