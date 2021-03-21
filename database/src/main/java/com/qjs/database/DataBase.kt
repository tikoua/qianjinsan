package com.qjs.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qjs.database.flow.FlowDetail
import com.qjs.database.flow.FlowDetailDao

/**
 * author: daichanglin
 * created on: 1/22/21 12:12 AM
 * description:
 */
@Database(entities = [FlowDetail::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun flowDetailDao(): FlowDetailDao
}