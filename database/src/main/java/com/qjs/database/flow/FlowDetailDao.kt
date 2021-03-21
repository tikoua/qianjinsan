package com.qjs.database.flow

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * author: daichanglin
 * created on: 1/22/21 12:06 AM
 * description:
 */
@Dao
interface FlowDetailDao {
    companion object {
        private const val TableName = FlowDetail.TableName
    }

    @Query("select * from ${TableName}")
    fun getAll(): List<FlowDetail>

    @Query("select * from ${TableName}")
    fun getAllAsFlow(): Flow<List<FlowDetail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg entities: FlowDetail)

    @Delete
    fun remove(like: FlowDetail)

    @Query("delete from $TableName where id = (:id)")
    fun deleteById(id: String)
}