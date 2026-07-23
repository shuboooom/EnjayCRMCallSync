package com.enjay.crm.callsync.data.repository

import android.util.Log
import com.enjay.crm.callsync.data.local.PostCallActivityDao
import com.enjay.crm.callsync.data.local.PostCallActivityEntity

class RoomPostCallActivityRepository(
    private val postCallActivityDao: PostCallActivityDao,
) : PostCallActivityRepository {

    override suspend fun addPostCallActivity(activity: PostCallActivityEntity): Long {
        val result = postCallActivityDao.insertPostCallActivity(activity)
        Log.d(
            TAG,
            "addPostCallActivity: result=$result leadId=${activity.leadId} leadCallLogId=${activity.leadCallLogId}",
        )
        return result
    }

    override suspend fun assignExternalIdIfMissing(activityId: Long) {
        val activity = postCallActivityDao.getById(activityId) ?: return
        if (activity.externalId.isBlank()) {
            postCallActivityDao.updatePostCallActivity(
                activity.copy(externalId = "activity-$activityId"),
            )
        }
    }

    override fun observePostCallActivitiesByLeadId(leadId: Long) = postCallActivityDao.observePostCallActivitiesByLeadId(leadId)

    override fun observePostCallActivityById(activityId: Long) = postCallActivityDao.observePostCallActivityById(activityId)

    companion object {
        private const val TAG = "EnjayCallSync"
    }
}
