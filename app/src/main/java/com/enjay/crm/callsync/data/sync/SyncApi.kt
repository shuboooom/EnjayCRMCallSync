package com.enjay.crm.callsync.data.sync

import retrofit2.http.Body
import retrofit2.http.POST

interface SyncApi {
    @POST("api/sync/push")
    suspend fun push(@Body request: PushRequestDto): PushResponseDto

    @POST("api/sync/pull")
    suspend fun pull(@Body request: PullRequestDto): PullResponseDto
}
