package com.example.askhat.afinal.localStorage

import android.arch.persistence.room.*
import com.example.askhat.afinal.entity.User
import io.reactivex.Maybe

@Dao
interface UserDao{

    @Insert
    fun addUser(user: User)

    @Query("SELECT * from user_table ")
    fun getUsers(): Maybe<List<User>>

}