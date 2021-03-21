package com.qjs.database

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration

/**
 * author: daichanglin
 * created on: 1/22/21 12:13 AM
 * description:
 */
object DataBaseHolder {
    private val dbMap = mutableMapOf<String, DataBase>()

    fun getDataBase(context: Context, dbName: String): DataBase {
        val dataBase = dbMap[dbName]
        if (dataBase != null) {
            return dataBase
        }
        return synchronized(dbMap) {
            dbMap[dbName] ?: {
                val migrationList = arrayOf<Migration>()
                Room.databaseBuilder(context.applicationContext, DataBase::class.java, dbName)
                    .addMigrations(*migrationList)
                    .build()
                    .also {
                        dbMap[dbName] = it
                    }
            }.invoke()
        }
    }
}