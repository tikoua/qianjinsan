package com.qjs.common.lib.kvdb

import com.tencent.mmkv.MMKV

/**
 * author: dcl
 * created on: 2020/11/19 12:36 PM
 * description: 基于微信MMKV的YNKV的实现
 */
internal class YNKVImpl(private val id: String?, model: Int = SINGLE_PROCESS_MODE) : YNKV {
    companion object {
        const val SINGLE_PROCESS_MODE = 1
        const val MULTI_PROCESS_MODE = 2

        /**
         * @param fileDir kvdb文件存放的位置
         */
        fun init(fileDir: String) {
            MMKV.initialize(fileDir)
        }

        /**
         * @param id 不同业务使用不同id分区存储 null则返回默认的对象
         * 默认是不区分用户的，如果需要区分不同用户需要在id中体现出来
         */
        fun getInstance(id: String?, model: Int = SINGLE_PROCESS_MODE): YNKV {
            return YNKVImpl(id, model)
        }


    }

    private val mmkv by lazy {
        if (id.isNullOrEmpty()) {
            MMKV.defaultMMKV()
        } else {
            val mmkvModel = when (model) {
                MULTI_PROCESS_MODE -> MMKV.MULTI_PROCESS_MODE
                else -> MMKV.SINGLE_PROCESS_MODE
            }
            MMKV.mmkvWithID(id, mmkvModel)
        }!!
    }

    override fun getId(): String? {
        return id
    }

    override fun getString(key: String?, defaultValue: String?): String? {
        if (key.isNullOrEmpty()) {
            return defaultValue
        }
        return mmkv.decodeString(key, defaultValue)
    }


    override fun setString(key: String?, value: String?) {
        if (key.isNullOrEmpty()) {
            return
        }
        if (value == null) {
            mmkv.removeValueForKey(key)
        } else {
            mmkv.encode(key, value)
        }
    }

    override fun getBool(key: String?, defaultValue: Boolean): Boolean {
        if (key.isNullOrEmpty()) {
            return defaultValue
        }
        return mmkv.decodeBool(key, defaultValue)
    }

    override fun setBool(key: String?, value: Boolean?) {
        if (key.isNullOrEmpty()) {
            return
        }
        if (value == null) {
            mmkv.removeValueForKey(key)
        } else {
            mmkv.encode(key, value)
        }
    }

    override fun getInt(key: String?, defaultValue: Int): Int {
        if (key.isNullOrEmpty()) {
            return defaultValue
        }
        return mmkv.decodeInt(key, defaultValue)
    }

    override fun setInt(key: String?, value: Int?) {
        if (key.isNullOrEmpty()) {
            return
        }
        if (value == null) {
            mmkv.removeValueForKey(key)
        } else {
            mmkv.encode(key, value)
        }
    }

    override fun setLong(key: String?, value: Long?) {
        if (key.isNullOrEmpty()) {
            return
        }
        if (value == null) {
            mmkv.removeValueForKey(key)
        } else {
            mmkv.encode(key, value)
        }
    }

    override fun getLong(key: String?, defaultValue: Long): Long {
        if (key.isNullOrEmpty()) {
            return defaultValue
        }
        return mmkv.decodeLong(key, defaultValue)
    }

    override fun remove(key: String?) {
        if (key.isNullOrEmpty()) {
            return
        }
        mmkv.removeValueForKey(key)
    }

    override fun containsKey(key: String?): Boolean {
        if (key.isNullOrEmpty()) {
            return false
        }
        return mmkv.containsKey(key)
    }


}