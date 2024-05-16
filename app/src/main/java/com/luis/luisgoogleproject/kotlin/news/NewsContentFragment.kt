package com.luis.luisgoogleproject.kotlin.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.luis.luisgoogleproject.R

class NewsContentFragment: Fragment() {
    lateinit var  contentLayout:LinearLayout
    lateinit var  newsTitle:TextView
    lateinit var  newsContent:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_content_frag, container, false)
        contentLayout = view.findViewById<View>(R.id.contentLayout) as LinearLayout
        newsTitle = view.findViewById<View>(R.id.newTitle) as TextView
        newsContent = view.findViewById<View>(R.id.newsContent) as TextView
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun refresh(title:String, content:String){
        contentLayout.visibility = View.VISIBLE
        newsTitle.text = title
        newsContent.text = content
    }
}