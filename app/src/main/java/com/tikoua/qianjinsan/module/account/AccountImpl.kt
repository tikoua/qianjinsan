package com.tikoua.qianjinsan.module.account

import android.content.Context
import com.qjs.database.DataBase
import com.qjs.database.DataBaseHolder

/**
 * author: daichanglin
 * created on: 1/21/21 11:42 PM
 * description:
 */
class AccountImpl(
    private val context: Context,
    override val uid: String,
    override var name: String
) : Account {
    val dbProvider: DataBase by lazy { DataBaseHolder.getDataBase(context, uid) }
}