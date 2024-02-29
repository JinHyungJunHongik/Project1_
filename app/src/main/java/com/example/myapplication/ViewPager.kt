package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager(activity: FragmentActivity) : FragmentStateAdapter(activity)  {
    val MemberList = listOf<Fragment>(
        OneFragment(),
        TwoFragment(),
        ThreeFragment()
    )
    override fun getItemCount(): Int {
        return MemberList.size
    }

    override fun createFragment(position: Int): Fragment {
       return MemberList[position]
    }
}