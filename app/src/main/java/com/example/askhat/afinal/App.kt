package com.example.askhat.afinal

import android.app.Application
import android.arch.persistence.room.Room
import com.example.askhat.afinal.localStorage.AppLocalDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        localDB = Room.databaseBuilder(this,AppLocalDatabase::class.java,"appDB").build()
    }

    companion object {
        var localDB:AppLocalDatabase?=null
    }
}