package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.rabbit, "이름","서해윤"),    //user.kt 클래스에 모델 객체 적었던 순서대로!
        User(R.drawable.enfj, "MBTI","ENFJ"),
        User(R.drawable.jazz, "취미", "여행,독서,재즈"),
        User(R.drawable.cat, "코딩경력","비전공자"),
        User(R.drawable.eggrice, "좋아하는 음식","간장계란밥"),
        User(R.drawable.pullup, "좋아하는 운동","풀업(35개까지 가능)"),
        User(R.drawable.camus, "좋아하는 작가","알베르 카뮈(Albert Camus)"),
        User(R.drawable.book, "좋아하는 책","시지프 신화"),
        User(R.drawable.casa, "좋아하는 영화","카사 블랑카(Casa Blanca)"),
        User(R.drawable.chet, "좋아하는 음악","It Could Happen To You"),
        User(R.drawable.passion, "다짐","7월까지 즐겁게 화이팅!")
    )
    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티의 실행시작지점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
//
//        val listView = findViewById<ListView>(R.id.listView)
//        val item = arrayOf("나","너","우리","당신","사랑")
//        listView.adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, item )  //context는 한 액티비티의 모든 정보를 담고 있다. // adapter는 플러그 연결하듯 코드 연결할 때 사용. ★리스트뷰는 어댑터가 있어야만 인풋하여 사용가능 즉, 리스트뷰와 배열을 연결시킨 것★ // 가운데 simple은 레이아웃 형태의미

        val listView = findViewById<ListView>(R.id.listView)
        val Adapter = profileAdapter(this,UserList)  // profileadapter 생성자 나와있는데로 생성자 호출시에 그 값들 전달해줄 것
        listView.adapter = Adapter  //★리스트뷰를 어뎁터와 연결시켰다. 그래서 이 액티비티의 내용들을 리스트뷰에 넣어주겠다는 것.★

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->    // 토스트 띄어주는 코드
            val selectItem = parent.getItemAtPosition(position) as User                     // parent 즉, 어뎁트뷰를 끌고온다  , 그 위치로 부터 아이템을 가져온다. as 모델형태로!
            Toast.makeText(this,selectItem.nameAnswer,Toast.LENGTH_SHORT).show()

        }

        val back = findViewById<ImageView>(R.id.iv_back)
        back.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }
}