package com.example.askhat.afinal.entity

import android.arch.persistence.room.*

@Entity(tableName = "contact_group",indices = arrayOf(Index(value = "group_id")))

data class ContactGroup(
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "priority") var priority:Int
    ){
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "group_id")  var id:Int?=null
    @Ignore
    constructor(id:Int, name:String, priority: Int):this(name,priority){
        this.id = id
    }
}