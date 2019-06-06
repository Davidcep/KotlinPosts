package com.example.kotlinposts.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.posts_layout.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvName = itemView.tvNombre
    val tvId = itemView.tvId
    val tvBody = itemView.tvBody
}