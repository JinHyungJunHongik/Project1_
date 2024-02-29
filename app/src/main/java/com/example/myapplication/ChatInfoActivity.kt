package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ChatInfoActivity : AppCompatActivity() {

    private val answerList: List<Message> = listOf(
        Message("대답", "이름: 양동원\n전화번호: 010-8709-1051\n취미:컴퓨터 게임\n하고싶은 말: 졸리다", "ic_launcher", 1),
        Message("대답", "강아지 매우 귀여움. 다시 보러 가는 것을 추천", "ic_launcher", 1),
        Message("대답", "아직 미정....", "ic_launcher", 1),
        Message("대답", "다시 입력해 주세요.", "ic_launcher", 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_info)

        var list = ArrayList<Message>()
        list.add(Message("대답", "무엇을 도와드릴까요?\n1. info\n2. pet\n3. photo", "ic_launcher", 1))

        val adapter = ChatAdapter(list)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_chat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val et_message = findViewById<EditText>(R.id.et_message)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val btn_chat_back = findViewById<Button>(R.id.btn_chat_back)
        btn_send.setOnClickListener{
            list.add(Message("나", et_message.text.toString(), "ic_launcher", 2))
            adapter.notifyDataSetChanged()
            et_message.text.clear()

            val temp = list[list.size-1].content.toLowerCase()
            if(temp.contains("info") || temp.contains("1")){
                list.add(answerList[0])
            } else if(temp.contains("pet") || temp.contains("2")){
                list.add(answerList[1])
            } else if(temp.contains("photo") || temp.contains("3")){
                list.add(answerList[2])
            } else {
                list.add(answerList[3])
            }
        }
        btn_chat_back.setOnClickListener{
            finish()
        }



    }
}
