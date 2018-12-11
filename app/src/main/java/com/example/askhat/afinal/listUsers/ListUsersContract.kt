package com.example.askhat.afinal.listUsers

import com.example.askhat.afinal.entity.AllDetail
import com.example.askhat.afinal.entity.User
import io.reactivex.Observable
import java.util.*
import kotlin.collections.ArrayList

interface ListUsersContract{

    interface ListUsersView {
        fun showList(allDetail: AllDetail)
    }

    interface ListUsersPresenter{
        fun onStart()
        fun getUsers()
    }

    interface ListUsersRepository{
        fun onStart()
        fun getUsers():Observable<AllDetail>
    }
}