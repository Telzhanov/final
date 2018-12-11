package com.example.askhat.afinal.listUsers

import android.arch.persistence.room.Room
import android.util.Log
import com.example.askhat.afinal.App.Companion.localDB
import com.example.askhat.afinal.entity.AllDetail
import com.example.askhat.afinal.entity.ContactGroup
import com.example.askhat.afinal.entity.User
import com.example.askhat.afinal.localStorage.AppLocalDatabase
import com.example.askhat.afinal.localStorage.LocalStorage
import com.example.askhat.afinal.localStorage.LocalStorageImpl
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.security.acl.Group

class ListUsersRepository:ListUsersContract.ListUsersRepository{
    lateinit var localStorage: LocalStorage
    override fun onStart() {
        localStorage = LocalStorageImpl(localDB!!)
    }

    override fun getUsers(): Observable<AllDetail> {
        return Observable.concat (
            localStorage.getContactGroup(),
            localStorage.getUsers())
            .map {
                val users = ArrayList<User>()
                val groups = ArrayList<ContactGroup>()
                for (i in it){
                    if (i is User){
                        users.add(i)
                    }
                    else{
                        groups.add(i as ContactGroup)
                    }
                }
                AllDetail(users,groups)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}