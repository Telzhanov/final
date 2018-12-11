package com.example.askhat.afinal.addUser

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.askhat.afinal.R
import com.example.askhat.afinal.addUser.AddUserActivity.Companion.selectedIndex
import com.example.askhat.afinal.entity.AllDetail
import com.example.askhat.afinal.entity.ContactGroup
import kotlinx.android.synthetic.main.group_item.view.*
import kotlinx.android.synthetic.main.item_card.view.*

class ListGroupAdapter(var listGroup: ArrayList<ContactGroup>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GroupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.group_item,parent,false))
    }

    override fun getItemCount(): Int {
        return listGroup.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.groupName.text = listGroup[position].name
        holder.itemView.setOnClickListener {
            selectedIndex = listGroup[position].id!!
        }
    }
    class GroupViewHolder(v: View): RecyclerView.ViewHolder(v)
}