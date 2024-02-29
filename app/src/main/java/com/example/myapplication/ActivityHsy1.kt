package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class ActivityHsy1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hsy1)

        val btn_to_2: Button = findViewById(R.id.btn_to_2)
        btn_to_2.setOnClickListener {
            // 버튼을 클릭했을 때 activity_hsy2.xml로 이동
            val intent = Intent(this, ActivityHsy2::class.java)
            startActivity(intent)
        }
    }
}

//AndroidManifast.xml에 activity 이름으로 추가하는 것 잊지 말기.
class ActivityHsy2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hsy2)

        val btn_to_3: Button = findViewById(R.id.btn_to_3)
        btn_to_3.setOnClickListener {
            // 버튼을 클릭했을 때 activity_hsy3.xml로 이동
            val intent = Intent(this, ActivityHsy3::class.java)
            startActivity(intent)
        }
    }
}


class ActivityHsy3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hsy3)

        val btn_to_main: Button = findViewById(R.id.btn_to_main)
        btn_to_main.setOnClickListener {
            // 버튼을 클릭했을 때 activity_hsy3.xml로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
