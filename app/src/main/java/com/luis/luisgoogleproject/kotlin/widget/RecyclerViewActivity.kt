package com.luis.luisgoogleproject.kotlin.widget

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.luis.luisgoogleproject.R
import com.luis.luisgoogleproject.kotlin.widget.adapter.Fruit
import com.luis.luisgoogleproject.kotlin.widget.adapter.FruitAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()
    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context, RecyclerViewActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initFruit()
        val fruitRv: RecyclerView = findViewById<RecyclerView>(R.id.fruitRv)
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL //横向
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL) //瀑布流布局
        fruitRv.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        fruitRv.adapter = adapter
    }

    private fun initFruit() {
        repeat(2){
            fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("banana"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("orange"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("watermelon"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("pear"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("grape"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("cherry"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("mango"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("pineApple"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("aa"), R.drawable.ic_cancel_black_24dp))
            fruitList.add(Fruit(getRandomLengthString("bb"), R.drawable.ic_cancel_black_24dp))
        }

    }

    private fun getRandomLengthString(str: String):String{
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }
}