package com.example.myapptransaction.usecase

import com.example.myappkit.base.BaseUseCase
import com.example.myappkit.constant.TagInjectConstant
import com.example.myapptransaction.model.DetailComment
import com.example.myapptransaction.repository.TransactionRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class DetailUseCase
@Inject constructor(
    private val repository: TransactionRepository,
    @Named(TagInjectConstant.SCHEDULER_EXECUTION) threadExecution: Scheduler,
    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION) postExecutionThread: Scheduler
) : BaseUseCase.RxSingle<DetailComment, DetailUseCase.Param>(threadExecution, postExecutionThread) {

    data class Param(
        var id: String
    )

    override fun build(params: Param?): Single<DetailComment> {
        params?.let {
            return repository.getDetail(it.id)
        }
        throw RuntimeException("Params not available")
    }
}