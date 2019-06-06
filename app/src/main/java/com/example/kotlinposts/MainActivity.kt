package com.example.kotlinposts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.kotlinposts.Adapter.PostAdapter
import com.example.kotlinposts.Model.Post
import com.example.kotlinposts.Retrofit.ApiPosts
import com.example.kotlinposts.Retrofit.Client
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var jsonApi: ApiPosts
    private lateinit var disposable: CompositeDisposable
    private lateinit var juju: List<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init API
        var retrofit: Retrofit = Client.getInstance
        jsonApi = retrofit.create(ApiPosts::class.java)

        //View
        rvPosts.setHasFixedSize(true)
        rvPosts.layoutManager = LinearLayoutManager(this)

        //Observer
        val myObserver = getObserver()

        //Observable
        var o: Observable<List<Post>> = jsonApi.posts

        o
            .subscribeOn(Schedulers.io())
            .subscribe(myObserver)
    }

    fun getObserver(): Observer<List<Post>> {
        return object : Observer<List<Post>> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: List<Post>) {
                Log.d("observer", t.size.toString())
                rvPosts.adapter = PostAdapter(t)
                juju = t
            }

            override fun onError(e: Throwable) {

            }

        }
    }
}
