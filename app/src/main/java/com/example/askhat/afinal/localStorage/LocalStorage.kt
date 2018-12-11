package com.example.askhat.afinal.localStorage

import com.example.askhat.afinal.entity.ContactGroup
import com.example.askhat.afinal.entity.User
import io.reactivex.Observable

interface LocalStorage{

    fun addUser(name:String, mobile:String,home:String,work:String,profile:String,contactGroup: Int)

    fun getUsers(): Observable<List<User>>

    fun addContactGroup(name:String, priority:Int)

    fun getContactGroup(): Observable<List<ContactGroup>>


}