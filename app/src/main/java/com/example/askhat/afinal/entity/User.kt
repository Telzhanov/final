package com.example.askhat.afinal.entity

import android.arch.persistence.room.*




@Entity(tableName = "user_table",foreignKeys = arrayOf(ForeignKey(entity = ContactGroup::class,
                                    parentColumns = arrayOf("group_id"),
                                    childColumns = arrayOf("contactGroup"),
                                    onDelete = ForeignKey.CASCADE
                                    )))
data class User(
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "mobile") var mobile:String,
    @ColumnInfo(name = "home") var home:String,
    @ColumnInfo(name = "work") var work:String,
    @ColumnInfo(name = "profile") var profile:String,
    @ColumnInfo(name = "contactGroup") var contactGroup: Int){
    @PrimaryKey(autoGenerate = true)  var id:Int?=null
    @Ignore
    constructor(id:Int, name:String, mobile: String,home:String,work:String,profile: String,contactGroup:Int):this(name,mobile,home,work,profile,contactGroup){
        this.id = id
    }
}