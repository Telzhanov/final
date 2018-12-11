package com.example.askhat.afinal.localStorage

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.askhat.afinal.entity.ContactGroup
import com.example.askhat.afinal.entity.User

@Database(entities = arrayOf(User::class, ContactGroup::class),version = 1)
abstract class AppLocalDatabase: RoomDatabase() {

    abstract fun userDao():UserDao
    abstract fun contactGroupDao():ContactGroupDao
}