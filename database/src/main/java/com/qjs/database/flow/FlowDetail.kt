package com.qjs.database.flow

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qjs.database.flow.FlowDetail.Companion.TableName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = TableName)
@Parcelize
data class FlowDetail(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    /**
     * 记录生成的时间:ms
     */
    var createTime: Long,
    /**
     * 流水类型[com.qjs.database.flow.FlowType]
     */
    var flowType: Int,
    /**
     * 单位：分
     */
    var amount: Int,
    /**
     * 账户[com.qjs.database.flow.FlowAccount]
     */
    var account: Int,
    /**
     * 原由：餐饮，购物，工资，公积金等
     * [com.qjs.database.flow.FlowReason]
     */
    var reason: Int,
    var note: String

) : Parcelable {
    companion object {
        const val TableName = "flow_detail"
    }
}
