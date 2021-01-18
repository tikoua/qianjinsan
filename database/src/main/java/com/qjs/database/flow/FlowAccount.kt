package com.qjs.database.flow

import android.os.Parcelable
import androidx.room.Entity
import com.qjs.database.flow.FlowAccount.Companion.TableName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = TableName)
@Parcelize
data class FlowAccount(
    /**
     * 类型：现金，储蓄卡，在线支付，储值卡，投资理财，其他
     */
    var type: Int,
    var name: String,
    /**
     * 余额:分
     */
    var balance: Int,
    /**
     * 备注
     */
    var note: String?
) : Parcelable {
    companion object {
        const val TableName = "flow_account"
    }
}