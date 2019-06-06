package com.example.kotlinposts.Retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
object Client {

    //Lazy es una función que durante la primera invocación ejecuta el lambda que se le haya pasado
    //y en posteriores invocaciones retornará el valor computado inicialmente.
    val getInstance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}