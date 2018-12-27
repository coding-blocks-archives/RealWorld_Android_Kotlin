package com.codingblocks.conduit.fragments.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.codingblocks.conduit.R
import com.codingblocks.conduit.adapters.ArticleFeedRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private var articleFeedRecyclerAdapter = ArticleFeedRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false).apply {
        this.rv_article_feed.layoutManager = LinearLayoutManager(context)
        this.rv_article_feed.adapter = articleFeedRecyclerAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.globalFeed.observe(
            { lifecycle },
            { articleFeedRecyclerAdapter.updateArticleList(it) }
        )

        viewModel.refreshGlobalFeed()
    }

}
