package com.example.askhat.afinal.listUsers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.askhat.afinal.R
import com.example.askhat.afinal.addUser.AddUserActivity
import com.example.askhat.afinal.entity.AllDetail
import com.example.askhat.afinal.entity.ContactGroup
import com.example.askhat.afinal.entity.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ListUsersContract.ListUsersView {
    var allDetail2 = AllDetail(ArrayList<User>(),ArrayList<ContactGroup>())
    override fun showList(allDetail: AllDetail) {
        if (allDetail.contactGroups.size!=0){
            allDetail2.contactGroups = allDetail.contactGroups
        }
        if (allDetail.users.size!=0){
            allDetail2.users = allDetail.users
        }
        if (allDetail2.users.size!=0 && allDetail2?.contactGroups.size!=0){
            listContact.layoutManager = LinearLayoutManager(this)
            listContact.adapter = ListUserAdapter(allDetail2)
        }
    }

    lateinit var presenter: ListUsersContract.ListUsersPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ListUsersPresenter(this)
        presenter.onStart()
        presenter.getUsers()

        floating.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }

    }
}
