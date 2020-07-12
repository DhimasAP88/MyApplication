package com.example.myapplication.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.myappkit.extention.disposedBy
import com.example.myapplication.R
import com.example.myapplication.common.base.BaseActivity
import com.example.myapplication.common.extention.UnspecifiedTypeItem
import com.example.myapplication.common.extention.performUpdates
import com.example.myapplication.detail.DetailActivity
import com.example.myapplication.home.listitem.CommentLIstItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : BaseActivity<HomeActivityViewModelType>() {
    @Inject
    lateinit var comentAdapter: FastItemAdapter<UnspecifiedTypeItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        bindViewEvent()
        bindViewModel()
    }

    private fun initView() {
        listComment?.apply {
            itemAnimator = null
            adapter = comentAdapter
            layoutManager = GridLayoutManager(
                this@HomeActivity,
                2, GridLayoutManager.VERTICAL, false
            )
        }
    }

    private fun bindViewEvent() {
        viewModel.inputs.sumNumber("1", "2")
    }

    private fun bindViewModel() {
        viewModel.outputs.showResultSum
            .subscribe {
                aselole.text = it
            }.disposedBy(compositeDisposable)

        viewModel.outputs.showListComment
            .subscribe {
                populateComment(it)
            }.disposedBy(compositeDisposable)
    }

    private fun populateComment(itemViewModel: List<HomeActivityItemViewModelType>) {
        val comment: List<UnspecifiedTypeItem> = itemViewModel.map {
            return@map when (it) {
                is HomeActivityItemViewModel -> createListComment(it)
            }
        }
        comentAdapter.performUpdates(comment)
    }

    private fun createListComment(viewModel: HomeActivityItemViewModel): CommentLIstItem {
        return CommentLIstItem(viewModel, object : CommentLIstItem.EventListener {
            override fun onClickItem(id: String) {
                val intent = Intent(this@HomeActivity, DetailActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }
        })
    }
}