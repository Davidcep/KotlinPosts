package com.example.kotlinposts.Retrofit

import com.example.kotlinposts.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiPosts {
    @get:GET("posts")
    val posts: Observable<List<Post>>
}