package com.techapp.james.drawacard

import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    var data = ArrayList<Item>()
    var tFlag = true
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

        var t = Thread(object : Runnable {
            override fun run() {
                while (tFlag) {
                    runOnUiThread {
                        shineImageView.alpha = shineImageView.alpha - 0.1f
                        if (shineImageView.alpha <= 0f) {
                            shineImageView.alpha = 1f
                        }
                    }
                    Thread.sleep(100)
                }
            }
        })
        t.start()

        Glide.with(this).load(R.drawable.mockbackground).into(mockImageView);
        randomRecyclerView.adapter = ListAdapter(this, data)

        randomBtn.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    randomBtn.alpha = 0.4f
                }
                MotionEvent.ACTION_UP -> {
                     randomBtn.text = ""
                    randomBtn.text = "Hide"
                    tFlag = false
                    randomBtn.alpha = 1f
                    shineImageView.alpha = 1f
                    var handler = Handler()
                    handler.postDelayed(object : Runnable {
                        override fun run() {
                            var ttt = Thread(object : Runnable {
                                override fun run() {
                                    while (shineImageView.alpha > 0) {
                                        shineImageView.alpha -= 0.1f
                                        Thread.sleep(50)
                                    }
                                }
                            })
                            ttt.start()
                            var number = (0..data.size - 1).random()
                            Log.d("num ", number.toString())
                            randomRecyclerView.smoothScrollToPosition(data.size - 1)
                            randomRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                                    super.onScrolled(recyclerView, dx, dy)
                                }

                                override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                                    super.onScrollStateChanged(recyclerView, newState)
                                    if (newState == 0) {
                                        var tt = Thread(object : Runnable {
                                            override fun run() {
                                                while (shineImageView.alpha >= 0) {
                                                    runOnUiThread(object : Runnable {
                                                        override fun run() {
                                                            shineImageView.alpha -= 0.1f
                                                        }
                                                    })
                                                    Thread.sleep(100)
                                                }
                                            }
                                        })
                                        var handler = Handler()
                                        handler.postDelayed(object : Runnable {
                                            override fun run() {
                                                shineImageView.visibility = View.VISIBLE
                                                shineImageView.alpha=1f
                                                randomBtn.isEnabled=false
                                                tt.start()
                                            }
                                        }, 200)

                                    }
                                }
                            })
                            mockImageView.visibility = View.INVISIBLE
                        }
                    }, 300)


                    // randomRecyclerView.scrollToPosition(number)

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
        i = Item(R.drawable.c11, R.drawable.background2, "11")
        data.add(i)
        i = Item(R.drawable.c12, R.drawable.background2, "12")
        data.add(i)
        i = Item(R.drawable.c13, R.drawable.background2, "13")
        data.add(i)

        i = Item(R.drawable.c21, R.drawable.background3, "21")
        data.add(i)
        i = Item(R.drawable.c22, R.drawable.background3, "22")
        data.add(i)
        i = Item(R.drawable.c23, R.drawable.background3, "23")
        data.add(i)

        i = Item(R.drawable.c31, R.drawable.background4, "31")
        data.add(i)
        i = Item(R.drawable.c32, R.drawable.background4, "32")
        data.add(i)
        i = Item(R.drawable.c33, R.drawable.background4, "33")
        data.add(i)

        i = Item(R.drawable.c41, R.drawable.background5, "41")
        data.add(i)
        i = Item(R.drawable.c42, R.drawable.background5, "42")
        data.add(i)

        i = Item(R.drawable.c43, R.drawable.background5, "43")
        data.add(i)

    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive - start) + start
}
