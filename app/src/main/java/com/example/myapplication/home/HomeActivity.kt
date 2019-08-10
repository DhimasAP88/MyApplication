package com.example.myapplication.home

import android.os.Bundle
import com.example.myappkit.extention.disposedBy
import com.example.myapplication.R
import com.example.myapplication.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity: BaseActivity<HomeActivityViewModelType>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViewEvent()
        bindViewModel()
    }

    private fun bindViewEvent() {
        viewModel.inputs.sumNumber("1","2")
    }

    private fun bindViewModel() {
        viewModel.outputs.showResultSum
            .subscribe {
                aselole.text = it
            }.disposedBy(compositeDisposable)
    }
}