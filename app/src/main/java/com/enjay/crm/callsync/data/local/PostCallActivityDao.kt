package com.enjay.crm.callsync.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PostCallActivityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostCallActivity(activity: PostCallActivityEntity): Long

    @Query("SELECT * FROM post_call_activities WHERE leadId = :leadId ORDER BY createdAt DESC")
    fun observePostCallActivitiesByLeadId(leadId: Long): Flow<List<PostCallActivityEntity>>

    @Query("SELECT * FROM post_call_activities WHERE id = :activityId LIMIT 1")
    fun observePostCallActivityById(activityId: Long): Flow<PostCallActivityEntity?>

    @Query("SELECT * FROM post_call_activities WHERE syncState != 'SYNCED' ORDER BY updatedAt ASC LIMIT :limit")
    suspend fun getPendingPostCallActivities(limit: Int): List<PostCallActivityEntity>

    @Query("SELECT COUNT(*) FROM post_call_activities WHERE syncState != 'SYNCED'")
    fun observePendingPostCallActivityCount(): Flow<Int>

    @Query("SELECT * FROM post_call_activities WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): PostCallActivityEntity?

    @Query("SELECT * FROM post_call_activities WHERE serverId = :serverId LIMIT 1")
    suspend fun findByServerId(serverId: String): PostCallActivityEntity?

    @Query("SELECT * FROM post_call_activities WHERE externalId = :externalId LIMIT 1")
    suspend fun findByExternalId(externalId: String): PostCallActivityEntity?

    @Update
    suspend fun updatePostCallActivity(activity: PostCallActivityEntity)

    @Query("UPDATE post_call_activities SET leadId = :toLeadId WHERE leadId = :fromLeadId")
    suspend fun reassignLead(fromLeadId: Long, toLeadId: Long)
}
