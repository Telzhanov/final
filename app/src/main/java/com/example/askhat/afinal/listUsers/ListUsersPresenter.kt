package com.example.askhat.afinal.listUsers

import android.annotation.SuppressLint
import android.util.Log
import com.example.askhat.afinal.entity.User
import io.reactivex.Observable

class ListUsersPresenter(val view: ListUsersContract.ListUsersView):ListUsersContract.ListUsersPresenter{
    lateinit var repo: ListUsersContract.ListUsersRepository
    override fun onStart() {
        repo = ListUsersRepository()
        repo.onStart()
    }

    @SuppressLint("CheckResult")
    override fun getUsers(){
        repo.getUsers()
            .subscribe {
                for (user in it.users){
                    Log.d("user", user.name)
                }
                for (group in it.contactGroups){
                    Log.d("groups",group.name)
                }
                view.showList(it)
            }
    }

}