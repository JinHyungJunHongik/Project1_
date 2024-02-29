package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class profileAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter()  // 이 어뎁터는 엑티비티의 모든 내용을 따르고, 배열은 user클래스의 자료형을 따라야한다.
{
    override fun getCount(): Int {
        return UserList.size  // 이만큼 리스트를 늘릴거야
    }

    override fun getItem(position: Int): Any {
        return UserList[position]  // 리스트인덱스만큼 아이템 받을 꺼야
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View { // 리스트뷰에서 뷰를 갯했을 때 어떻게 뿌려줄 것인가.   선언한 모델 객체별로 잘 선언해주면 됨
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_profile, null)  // 레이아웃 인플레이터는 뷰를 붙힌다

        val profile = view.findViewById<ImageView>(R.id.iv_rabbit)   //리스트가 추가 되면서 바뀌는 그림 담는 변수
        val name = view.findViewById<TextView>(R.id.tv_name)
        val nameAnswer = view.findViewById<TextView>(R.id.tv_nameAnswer)

        val user = UserList[position]  // 위치. 즉, 리스트의 인덱스  ★

        profile.setImageResource(user.profile)  // 나중에 여기에 drawble 형태의 경로를 넣어줄 것이다. 그래야 칸마다 그림이 바뀐다.
        name.text = user.name
        nameAnswer.text = user.nameAnswer

        return view

    }

}