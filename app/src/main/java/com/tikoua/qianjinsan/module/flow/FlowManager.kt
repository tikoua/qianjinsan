package com.tikoua.qianjinsan.module.flow

import com.qjs.database.flow.FlowDetail
import kotlinx.coroutines.flow.Flow

/**
 * author: daichanglin
 * created on: 1/21/21 11:44 PM
 * description:
 */
interface FlowManager {
    fun allFlow(): Flow<List<FlowDetail>>

}