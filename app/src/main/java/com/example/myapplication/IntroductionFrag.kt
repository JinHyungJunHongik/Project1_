package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class IntroductionFrag :Fragment(){
    var introductionType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let{
            introductionType = it.getInt(ARG_INTRODUCTION_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var resource = selectPageFragemnt(introductionType)
        val view = inflater.inflate(resource, container, false)

        if(resource == R.layout.introduction_fragment4) {
            val btn_chat = view.findViewById<Button>(R.id.btn_chat_info)
            val btn_chat_no = view.findViewById<Button>(R.id.btn_chat_no)

            btn_chat.setOnClickListener{
                val intent = Intent(requireActivity(), ChatInfoActivity::class.java)
                startActivity(intent)
            }

            btn_chat_no.setOnClickListener{
                requireActivity().finish()
            }
        }
        return view
    }


    fun selectPageFragemnt(position: Int) : Int{
        var resource : Int
        when(position){
            0 -> resource = R.layout.introduction_fragment
            1 -> resource = R.layout.introduction_fragment2
            2 -> resource = R.layout.introduction_fragment3
            else -> resource = R.layout.introduction_fragment4
        }
        return resource
    }

    companion object{
        private const val ARG_INTRODUCTION_TYPE = "introductionType"

        fun newInstance(position: Int): Fragment{
            val frag = IntroductionFrag()
            val args = Bundle()

            args.putInt(ARG_INTRODUCTION_TYPE, position)
            frag.arguments = args
            return  frag
        }

    }
}