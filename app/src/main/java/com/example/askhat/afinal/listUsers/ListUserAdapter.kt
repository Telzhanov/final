package com.example.askhat.afinal.listUsers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.askhat.afinal.R
import com.example.askhat.afinal.entity.AllDetail
import kotlinx.android.synthetic.main.item_card.view.*

class ListUserAdapter(var allDetail: AllDetail):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false))
    }

    override fun getItemCount(): Int {
        return allDetail.users.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.postTitle.text = allDetail.users[position].name
        for (i in 0..allDetail.contactGroups.size){
            if (allDetail.users[position].contactGroup==allDetail.contactGroups[i].id){
                holder.itemView.postDate.text = allDetail.contactGroups[i].name
                break
            }
        }
    }
    class UserViewHolder(v: View):RecyclerView.ViewHolder(v)
}