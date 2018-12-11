package com.example.askhat.afinal.localStorage

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.askhat.afinal.entity.ContactGroup
import com.example.askhat.afinal.entity.User
import io.reactivex.Maybe

@Dao
interface ContactGroupDao{
    @Insert
    fun addContactGroup(contactGroup: ContactGroup)

    @Query("SELECT * from contact_group")
    fun getContactGroup(): Maybe<List<ContactGroup>>
}