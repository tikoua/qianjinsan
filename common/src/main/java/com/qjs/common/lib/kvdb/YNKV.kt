package com.qjs.common.lib.kvdb

import android.content.Context

/**
 * author: dcl
 * created on: 2020/11/19 11:40 AM
 * description: 存储key-value的类
 */
interface YNKV {
    fun getId(): String?
    fun setString(key: String?, value: String?)
    fun getString(key: String?, defaultValue: String? = null): String?
    fun setBool(key: String?, value: Boolean?)
    fun getBool(key: String?, defaultValue: Boolean = false): Boolean
    fun setInt(key: String?, value: Int?)
    fun getInt(key: String?, defaultValue: Int = 0): Int
    fun setLong(key: String?, value: Long?)
    fun getLong(key: String?, defaultValue: Long = 0): Long
    fun remove(key: String?)
    fun containsKey(key: String?): Boolean
}