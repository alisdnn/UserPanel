package com.alisdnn.userpanel.presentation.base.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alisdnn.userpanel.domain.base.RecyclerItem

val BASE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<RecyclerItem>() {

    override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem == newItem
    }

}