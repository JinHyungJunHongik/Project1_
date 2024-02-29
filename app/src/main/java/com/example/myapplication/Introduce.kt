package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityIntroduceBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class Introduce : AppCompatActivity() {
    lateinit var binding: ActivityIntroduceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var number_of_heart : Int = 0
        binding = ActivityIntroduceBinding.inflate(layoutInflater)
        binding.introduce.adapter = ViewPager(this)
        binding.IconHeart.setOnClickListener {
            binding.IconHeart.setImageResource(R.drawable.fill_heart)
            number_of_heart++
            binding.numberLove.text = number_of_heart.toString()
        }
        binding.tabs.setTabTextColors(Color.rgb(105, 105, 105),Color.rgb(0, 0, 255))
        TabLayoutMediator(binding.tabs, binding.introduce){
                tab, position ->
            when(position){
                0 -> tab.text = "ㆍ"
                else -> tab.text = "ㆍ"
            }

        }.attach()
        binding.IconButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val pageChangeCallback = object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.pagenumber.text = "${position+1}"
            }
        }
        binding.introduce.registerOnPageChangeCallback(pageChangeCallback)
        binding.btnPlus.setOnClickListener {
        binding.btnPlus.isGone = true
            binding.MainIntroduce2.isVisible = true
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}