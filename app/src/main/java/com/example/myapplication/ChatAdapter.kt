package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatList : ArrayList<Message>): RecyclerView.Adapter<ChatAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_message, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = chatList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    class ViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        var sender = view.findViewById<TextView>(R.id.tv_sender)
        var content = view.findViewById<TextView>(R.id.tv_message)
        var img_type = view.findViewById<ImageView>(R.id.iv_sender)
        var linearLayout = view.findViewById<LinearLayout>(R.id.ll_itemMessage)

        fun bind(item: Message){
            if(item.sender_type==1){
                sender = view.findViewById<TextView>(R.id.tv_sender)
                content = view.findViewById<TextView>(R.id.tv_message)
                img_type = view.findViewById<ImageView>(R.id.iv_sender)
                linearLayout = view.findViewById<LinearLayout>(R.id.ll_itemMessage2)
                linearLayout.visibility = View.GONE
                linearLayout = view.findViewById<LinearLayout>(R.id.ll_itemMessage)
                linearLayout.visibility = View.VISIBLE
            } else {
                sender = view.findViewById<TextView>(R.id.tv_sender2)
                content = view.findViewById<TextView>(R.id.tv_message2)
                img_type = view.findViewById<ImageView>(R.id.iv_sender2)
                linearLayout = view.findViewById<LinearLayout>(R.id.ll_itemMessage)
                linearLayout.visibility = View.GONE
                linearLayout = view.findViewById<LinearLayout>(R.id.ll_itemMessage2)
                linearLayout.visibility = View.VISIBLE
            }

            sender.text = item.sender
            content.text = item.content
            val resId = view.context.resources.getIdentifier(item.img_type, "drawable", view.context.packageName)
            img_type.setImageResource(resId)

        }
    }
}