package com.codingblocks.conduit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingblocks.conduit.R
import com.codingblocks.conduit.data.models.Article
import kotlinx.android.synthetic.main.list_item_article.view.*


class ArticleFeedRecyclerAdapter
    : RecyclerView.Adapter<ArticleFeedRecyclerAdapter.ArticleViewHolder>() {

    private var articleList = ArrayList<Article>()
    var onArticleClicked: ((Article) -> Unit)? = null

    fun updateArticleList(newArticleList: ArrayList<Article>) {
        articleList.clear()
        articleList.addAll(newArticleList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        with(parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater) {
            ArticleViewHolder(
                inflate(R.layout.list_item_article, parent, false),
                onArticleClicked
            )
        }


    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindView(articleList[position])
    }


    class ArticleViewHolder(
        itemView: View,
        var onArticleClicked: ((Article) -> Unit)?
    ) : RecyclerView.ViewHolder(itemView) {
        fun bindView(article: Article) {
            onArticleClicked?.let {
                itemView.setOnClickListener { it(article) }
            }
            itemView.tv_article_title.text = article.title
            if (article.body.length > 100) {
                itemView.tv_article_description.text = article.body.substring(100) + " . . . "
            } else {
                itemView.tv_article_description.text = article.body
            }
        }
    }
}