package com.codingblocks.conduit.fragments.article

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.codingblocks.conduit.R
import com.codingblocks.conduit.viewmodels.ArticlesViewModel

class ReadArticleFragment : Fragment() {

    companion object {
        fun newInstance() = ReadArticleFragment()
    }

    private lateinit var viewModel: ArticlesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_read_article, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(ArticlesViewModel::class.java)
        }

    }

}
