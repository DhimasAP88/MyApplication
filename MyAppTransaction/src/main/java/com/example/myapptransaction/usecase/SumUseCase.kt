package com.example.myapptransaction.usecase

import com.example.myappkit.base.BaseUseCase
import com.example.myappkit.constant.TagInjectConstant
import com.example.myapptransaction.repository.TransactionRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class SumUseCase
@Inject constructor(private val repository: TransactionRepository,
                    @Named(TagInjectConstant.SCHEDULER_EXECUTION) threadExecution: Scheduler,
                    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION) postExecutionThread: Scheduler)
    : BaseUseCase.RxSingle<List<Int>, SumUseCase.Param>(threadExecution, postExecutionThread) {
    override fun build(params: Param?): Single<List<Int>> {
        params?.let {
            return repository.test(firstNumber = it.firstNumber, secondNumber = it.secondNumber)
        }
        throw RuntimeException("Param not available")
    }

    data class Param(
        var firstNumber: String,
        var secondNumber: String
    )
}