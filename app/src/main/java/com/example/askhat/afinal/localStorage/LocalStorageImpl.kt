package com.example.askhat.afinal.localStorage

import com.example.askhat.afinal.entity.ContactGroup
import com.example.askhat.afinal.entity.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalStorageImpl(private var appLocalDatabase: AppLocalDatabase):LocalStorage{
    override fun addContactGroup(name: String, priority: Int) {
        Observable.fromCallable {
            appLocalDatabase.contactGroupDao().addContactGroup(ContactGroup(name,priority))
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    override fun getContactGroup(): Observable<List<ContactGroup>> {
        return appLocalDatabase.contactGroupDao().getContactGroup().toObservable()
    }

    override fun getUsers(): Observable<List<User>> {
        return appLocalDatabase.userDao().getUsers().toObservable()
    }

    override fun addUser(name: String, mobile: String,home:String,work:String,profile:String, contactGroup: Int) {
        Observable.fromCallable {
            appLocalDatabase.userDao().addUser(User(name,mobile,home,work,profile,contactGroup))
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}