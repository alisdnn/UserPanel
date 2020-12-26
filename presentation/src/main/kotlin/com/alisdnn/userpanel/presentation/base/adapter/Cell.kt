package com.alisdnn.userpanel.presentation.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alisdnn.userpanel.domain.base.RecyclerItem

interface Cell<T, R> {

    fun belongsTo(item: T?): Boolean
    fun type(): Int
    fun binding(parent: ViewGroup): R
    fun holder(parent: ViewGroup): RecyclerView.ViewHolder
    fun bind(
        holder: RecyclerView.ViewHolder,
        item: T?,
        onItemClick: ((RecyclerItem, View) -> Unit)?
    )

}