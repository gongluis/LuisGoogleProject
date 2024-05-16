package com.luis.luisgoogleproject.kotlin.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luis.luisgoogleproject.R

class NewsTitleFragment : Fragment() {
    private var isTwoPane = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_title, container, false)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.contentLayout) !=null
    }


    inner class NewsAdapter(val newsList: List<News>):RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
        inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.bindingAdapterPosition]
                if(isTwoPane){
                    //如果是双页模式，则刷新NewsContentFragment中的内容
//                    val fragment =activity.supportFragmentManager.findFragmentById(R.id.newsContentFrag)as NewsContentFragment
//                    fragment.refresh(news.title, news.content)

                }else{
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }

            }
            return holder
        }

        override fun getItemCount()=newsList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           val new = newsList[position]
            holder.newsTitle.text = new.title
        }
    }
}