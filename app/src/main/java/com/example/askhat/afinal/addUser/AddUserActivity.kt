package com.example.askhat.afinal.addUser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.askhat.afinal.App.Companion.localDB
import com.example.askhat.afinal.R
import com.example.askhat.afinal.localStorage.LocalStorageImpl
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity(), AddUserContract.AddUserView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        var localStorage = LocalStorageImpl(localDB!!)

        localStorage.addUser(titlePost.)
    }
}
