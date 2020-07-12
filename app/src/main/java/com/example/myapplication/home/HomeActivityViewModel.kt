package com.example.myapplication.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.example.myapplication.common.base.ViewModelType
import com.example.myapptransaction.usecase.SumUseCase
import io.reactivex.Observable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject
import java.lang.IllegalArgumentException
import javax.inject.Inject

interface HomeActivityViewModelType : ViewModelType {
    val inputs: Inputs
    val outputs: Outputs

    interface Inputs{
        fun sumNumber(firstNumber: String,
                      secondNumber: String)
    }
    interface Outputs{
        val showResultSum: Observable<String>
        val showListComment: Observable<List<HomeActivityItemViewModelType>>
    }
}
class HomeActivityViewModel(val getSumUseCase: SumUseCase) :
    ViewModel(),
    HomeActivityViewModelType,
    HomeActivityViewModelType.Inputs,
    HomeActivityViewModelType.Outputs {

    private val sumResult = PublishSubject.create<String>()
    private val listComment = PublishSubject.create<List<HomeActivityItemViewModelType>>()
    override val inputs: HomeActivityViewModelType.Inputs
        get() = this
    override val outputs: HomeActivityViewModelType.Outputs
        get() = this


    override val showResultSum: Observable<String>
        get() = sumResult
    override val showListComment: Observable<List<HomeActivityItemViewModelType>>
        get() = listComment


        override fun sumNumber(firstNumber: String, secondNumber: String) {
        getSumUseCase.execute(SumNumberObserver(), SumUseCase.Param(
            firstNumber = firstNumber,
            secondNumber = secondNumber
        ))
    }

    override fun onCleared() {
        super.onCleared()
        getSumUseCase.dispose()
    }

    private fun updateList(listComment: List<Int>) {
        val itemModel = mutableListOf<HomeActivityItemViewModel>()
        itemModel.addAll(listComment.map { HomeActivityItemViewModel.create(it) })
        this.listComment.onNext(itemModel)
    }


    @Suppress("UNCHECKED_CAST")
    class Factory
    @Inject constructor(private val getSumUseCase: SumUseCase): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeActivityViewModel::class.java)) {
                return HomeActivityViewModel(getSumUseCase = getSumUseCase) as T
            }
            throw IllegalArgumentException("Unknown Viewmodel class")
        }

    }

    inner class SumNumberObserver : DisposableSingleObserver<List<Int>>() {
        override fun onSuccess(t: List<Int>) {
//            sumResult.onNext(t)
            updateList(t)
        }

        override fun onError(e: Throwable) {
//            Log.e("error", e.message)
        }

    }
}