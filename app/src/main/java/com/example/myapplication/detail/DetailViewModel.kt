package com.example.myapplication.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.myapplication.common.base.ViewModelType
import com.example.myapptransaction.model.DetailComment
import com.example.myapptransaction.usecase.DetailUseCase
import io.reactivex.Observable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

interface DetailViewModelType : ViewModelType {
    interface Inputs {
        fun getDetail(id: String)
    }

    interface Outputs {
        val shouldUpdateView: Observable<Triple<String, String, String>>
    }

    val input: Inputs
    val output: Outputs
}


class DetailViewModel(val detailUseCase: DetailUseCase) : ViewModel(),
    DetailViewModelType,
    DetailViewModelType.Inputs,
    DetailViewModelType.Outputs {
    override val input: DetailViewModelType.Inputs
        get() = this
    override val output: DetailViewModelType.Outputs
        get() = this

    override fun onCleared() {
        super.onCleared()
        detailUseCase.dispose()
    }

    override fun getDetail(id: String) {
        detailUseCase.execute(DetailCommentObserver(), DetailUseCase.Param(id = id))
    }

    private val shouldUpdate = PublishSubject.create<Triple<String, String, String>>()

    @Suppress("UNCHECKED_CAST")
    class Factory
    @Inject constructor(private val detailUseCase: DetailUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
                return DetailViewModel(detailUseCase) as T
            }
            throw IllegalArgumentException("Unknown viewmodel class")
        }

    }

    inner class DetailCommentObserver : DisposableSingleObserver<DetailComment>() {
        override fun onSuccess(t: DetailComment) {
            shouldUpdate.onNext(Triple(t.title, t.by, getDateTime(t.time)))
        }

        override fun onError(e: Throwable) {
        }

    }

    private fun getDateTime(s: Long): String {
        return try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(s)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

    override val shouldUpdateView: Observable<Triple<String, String, String>>
        get() = shouldUpdate

}