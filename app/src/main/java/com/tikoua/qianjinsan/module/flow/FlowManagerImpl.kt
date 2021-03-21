package com.tikoua.qianjinsan.module.flow

import android.content.Context
import com.qjs.database.flow.FlowDetail
import com.qjs.database.flow.FlowDetailDao
import kotlinx.coroutines.flow.Flow

/**
 * author: daichanglin
 * created on: 1/22/21 12:05 AM
 * description:
 */
class FlowManagerImpl(
    private val context: Context,
    private val flowDetailDao: FlowDetailDao
) : FlowManager {
    override fun allFlow(): Flow<List<FlowDetail>> {
        return flowDetailDao.getAllAsFlow()
    }
}