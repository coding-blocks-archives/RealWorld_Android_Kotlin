package com.codingblocks.conduit.fragments.article


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.codingblocks.conduit.R
import com.codingblocks.conduit.viewmodels.ArticlesViewModel


/**
 * A simple [Fragment] subclass.
 *
 */
class EditArticleFragment : Fragment() {

    companion object {
        fun newInstance() = EditArticleFragment()
    }

    private lateinit var viewModel: ArticlesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_article, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArticlesViewModel::class.java)
        // TODO: Use the ViewModel
    }


}
