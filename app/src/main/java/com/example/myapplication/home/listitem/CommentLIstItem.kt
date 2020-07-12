package com.example.myapplication.home.listitem

import android.view.View
import com.example.myapplication.R
import com.example.myapplication.common.base.BindableListItemViewHolder
import com.example.myapplication.databinding.ListItemCommentBinding
import com.example.myapplication.home.HomeActivityItemViewModel
import com.mikepenz.fastadapter.items.AbstractItem

class CommentLIstItem(val viewModel: HomeActivityItemViewModel, val eventListener: EventListener) : AbstractItem<CommentLIstItem, CommentLIstItem.ViewHolder>() {

    class ViewHolder(view: View) : BindableListItemViewHolder<ListItemCommentBinding>(view)

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.list_item_comment

    private val onClickListener = View.OnClickListener {
        eventListener.onClickItem(viewModel.id.toString())
    }

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.viewmodel = viewModel
        holder.binding.idComment.setOnClickListener(onClickListener)
    }

    interface EventListener {
        fun onClickItem(id: String)
    }
}