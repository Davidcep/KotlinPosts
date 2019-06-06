package com.example.kotlinposts.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlinposts.Model.Post
import com.example.kotlinposts.R

class PostAdapter(private val data: List<Post>): RecyclerView.Adapter<PostViewHolder>() {

    //Overwrite posts_layout with the PostViewHolder
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.posts_layout, p0, false)
        return PostViewHolder(itemView)
    }

    //RecyclerView size
    override fun getItemCount(): Int {
        return data.size
    }

    //Get items from ViewHolder to RecyclerView
    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        p0.tvName.text = data[p1].title
        p0.tvId.text = data[p1].id.toString()
        p0.tvBody.text = data[p1].userId.toString()
    }


}