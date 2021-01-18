package com.qjs.database.flow

import android.os.Parcelable
import androidx.room.Entity
import com.qjs.database.flow.FlowReason.Companion.TableName
import kotlinx.android.parcel.Parcelize

/**
 * 可以新，新建[FlowReason]类别时生成新的唯一的 [reasonType]
 */
@Entity(tableName = TableName)

@Parcelize
data class FlowReason(
    val reasonType: Int,

    var name: String,
    var icon: String?,
    /**
     * 是否显示在快捷添加的面板
     */
    var showAsQuick: Boolean = false,
    /**
     *[com.qjs.database.flow.FlowType]
     */
    var flowType: Int
) : Parcelable {
    companion object {
        const val TableName = "flow_reason"
    }
}