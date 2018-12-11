package com.example.askhat.afinal.addUser

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.askhat.afinal.App.Companion.localDB
import com.example.askhat.afinal.R
import com.example.askhat.afinal.entity.ContactGroup
import com.example.askhat.afinal.listUsers.MainActivity
import com.example.askhat.afinal.localStorage.LocalStorageImpl
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity(), AddUserContract.AddUserView {

    companion object {
        var selectedIndex = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        var localStorage = LocalStorageImpl(localDB!!)

        localStorage.getContactGroup().subscribe {
            Log.d("listGroupSize", it.size.toString())
            listGroup.layoutManager = LinearLayoutManager(this)
            listGroup.adapter = ListGroupAdapter(it as ArrayList<ContactGroup>)
        }

        addButton.setOnClickListener {
            localStorage.addUser(titlePost.text.toString(),mobile.text.toString(),home.text.toString(),work.text.toString(),
                " ", selectedIndex)
            finish()
            val intent = Intent (this, MainActivity::class.java )
            startActivity(intent)
        }


    }
}
