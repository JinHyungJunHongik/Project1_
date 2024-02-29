package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

class IntroductionActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    private lateinit var tv_page1: TextView
    private lateinit var tv_page2: TextView
    private lateinit var tv_page3: TextView
    private lateinit var tv_page4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        tv_page1 = findViewById<TextView>(R.id.tv_page1)
        tv_page2 = findViewById<TextView>(R.id.tv_page2)
        tv_page3 = findViewById<TextView>(R.id.tv_page3)
        tv_page4 = findViewById<TextView>(R.id.tv_page4)

        viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = ViewpagerAdapter(this)
        viewPager.isUserInputEnabled = true;

        val tv_pageName = findViewById<TextView>(R.id.tv_pageName)

        var tv_pages = listOf(tv_page1, tv_page2, tv_page3, tv_page4)
        for((index, textView) in tv_pages.withIndex()) { textView.setOnClickListener {
            viewPager.currentItem = index
        } }

        val iv_back = findViewById<ImageView>(R.id.iv_intro_back)
        iv_back.setOnClickListener{
            finish()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateTextViewColor(position)
                when(position) {
                    0 -> tv_pageName.text = "Info"
                    1 -> tv_pageName.text = "Pet"
                    2 -> tv_pageName.text = "Photo"
                    3 -> tv_pageName.text = "Chat"
                }
            }
        })
    }

    fun updateTextViewColor(position: Int){
        var tv_pages = listOf(tv_page1, tv_page2, tv_page3, tv_page4)

        tv_pages.forEachIndexed { index, textView ->
            textView.setBackgroundResource(if (index == position) R.drawable.btn_introduction_bg_selected else R.drawable.btn_introduction_bg)
        }
    }
}