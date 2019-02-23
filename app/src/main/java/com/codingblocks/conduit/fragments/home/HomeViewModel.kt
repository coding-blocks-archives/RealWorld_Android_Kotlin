package com.codingblocks.conduit.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.codingblocks.conduit.data.ConduitClient
import com.codingblocks.conduit.data.models.Article
import com.codingblocks.conduit.extensions.enqueue

class HomeViewModel : ViewModel() {

    val globalFeed: MutableLiveData<ArrayList<Article>> by lazy {
        MutableLiveData<ArrayList<Article>>()
    }

    fun refreshGlobalFeed () {
        ConduitClient.conduitApi.getArticles().enqueue { t, response ->
            response?.body()?.let {
                globalFeed.postValue(it.articles)
            }
        }
    }

}
