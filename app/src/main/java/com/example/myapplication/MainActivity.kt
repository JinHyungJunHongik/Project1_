package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ll_team1 = findViewById<LinearLayout>(R.id.ll_team1)
        val ll_team2 = findViewById<LinearLayout>(R.id.ll_team2)
        val ll_team3 = findViewById<LinearLayout>(R.id.ll_team3)
        val ll_team4 = findViewById<LinearLayout>(R.id.ll_team4)


        onClickLayer(ll_team1, ActivityHsy1::class.java)
        onClickLayer(ll_team2, Introduce::class.java)
        onClickLayer(ll_team3, IntroductionActivity::class.java)
        onClickLayer(ll_team4, MainActivityHW::class.java)
    }

    fun onClickLayer(layout: LinearLayout, destinationActivity: Class<*>) {
        layout.setOnClickListener {
            val intent = Intent(this, destinationActivity)
            startActivity(intent)
        }
    }
}