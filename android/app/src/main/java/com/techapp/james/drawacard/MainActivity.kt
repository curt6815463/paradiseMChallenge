package com.techapp.james.drawacard

import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    var data = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorBlack));
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        randomRecyclerView.layoutManager = layoutManager
        randomRecyclerView.isEnabled = false
        setData()


        Glide.with(this).load(R.drawable.mockbackground).into(mockImageView);
        randomRecyclerView.adapter = ListAdapter(this, data)

        randomBtn.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    randomBtn.alpha = 0.4f
                    randomBtn.text = ""
                }
                MotionEvent.ACTION_UP -> {
                    randomBtn.text = "Hide"
                    randomBtn.alpha = 1f
                    var handler= Handler()
                    handler.postDelayed(object :Runnable{
                        override fun run() {
                            shineImageView.visibility=View.INVISIBLE
                        }
                    },2)

                    var number = (0..data.size - 1).random()
                    Log.d("num ", number.toString())
                    // randomRecyclerView.scrollToPosition(number)
                    randomRecyclerView.smoothScrollToPosition(number)
                    cardMaskImageView.visibility = View.INVISIBLE
                }
            }
            true
        }
//        randomBtn.setOnClickListener {
//            var number = (0..data.size - 1).random()
////            randomRecyclerView.scrollToPosition(number)
//            randomRecyclerView.smoothScrollToPosition(number)
//        }
    }

    fun setData() {
        var i = Item(R.drawable.c1, R.drawable.background1, "1")
        data.add(i)
        i = Item(R.drawable.c2, R.drawable.background1, "2")
        data.add(i)
        i = Item(R.drawable.c3, R.drawable.background1, "3")
        data.add(i)
        i = Item(R.drawable.c4, R.drawable.background2, "4")
        data.add(i)
        i = Item(R.drawable.c5, R.drawable.background2, "5")
        data.add(i)
        i = Item(R.drawable.c6, R.drawable.background2, "6")
        data.add(i)
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive - start) + start
}
