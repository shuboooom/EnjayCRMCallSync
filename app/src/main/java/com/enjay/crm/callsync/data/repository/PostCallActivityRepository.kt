package com.enjay.crm.callsync.data.repository

import com.enjay.crm.callsync.data.local.PostCallActivityEntity
import kotlinx.coroutines.flow.Flow

interface PostCallActivityRepository {
    suspend fun addPostCallActivity(activity: PostCallActivityEntity): Long
    suspend fun assignExternalIdIfMissing(activityId: Long)
    fun observePostCallActivitiesByLeadId(leadId: Long): Flow<List<PostCallActivityEntity>>
    fun observePostCallActivityById(activityId: Long): Flow<PostCallActivityEntity?>
}
