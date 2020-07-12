package com.example.myapplication.detail

import android.os.Bundle
import com.example.myappkit.extention.disposedBy
import com.example.myapplication.R
import com.example.myapplication.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<DetailViewModelType>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindViewEvent()
        bindViewModel()
    }

    private fun bindViewEvent() {
        viewModel.input.getDetail(intent.getStringExtra("id"))
    }

    private fun bindViewModel() {
        viewModel.output.shouldUpdateView.subscribe {
            title_comment?.text = it.first
            author?.text = "by ${it.second}"
            date?.text = it.third
        }.disposedBy(compositeDisposable)
    }
}