package com.codingblocks.conduit.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.codingblocks.conduit.data.ConduitClient
import com.codingblocks.conduit.data.models.Article
import com.codingblocks.conduit.extensions.enqueue

class ArticlesViewModel : ViewModel() {

    val globalFeed: MutableLiveData<ArrayList<Article>> by lazy {
        MutableLiveData<ArrayList<Article>>()
    }

    val currentArticle: MutableLiveData<Article> by lazy {
        MutableLiveData<Article>()
    }

    fun refreshGlobalFeed () {
        ConduitClient.conduitApi.getArticles().enqueue { t, response ->
            response?.body()?.let {
                globalFeed.postValue(it.articles)
            } ?:
            Log.e(
                "HOME",
                "Error downloading articles",
                t
            )
        }
    }

}
