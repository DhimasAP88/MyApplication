package com.example.myappaccount.usecase

import com.example.myappaccount.model.AccountModel
import com.example.myappaccount.repository.AccountRepository
import com.example.myappkit.base.BaseUseCase
import com.example.myappkit.constant.TagInjectConstant
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class GetAccountBaseUseCase
@Inject constructor(
    private val repository: AccountRepository,
    @Named(TagInjectConstant.SCHEDULER_EXECUTION) threadExecutor: Scheduler,
    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION) postExecutionThread: Scheduler)
    : BaseUseCase.RxSingle<AccountModel, Unit>(threadExecutor, postExecutionThread){
    override fun build(params: Unit?): Single<AccountModel> {
        return repository.getAccount()
    }

}