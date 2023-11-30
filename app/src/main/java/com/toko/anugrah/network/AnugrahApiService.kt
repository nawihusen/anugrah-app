package com.toko.anugrah.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface AnugrahApiService {
    @GET("product")
    fun getAllUser(): Flow<List<User>>

//    @GET("photos")
//    suspend fun getPhotos(): List<MarsPhoto>
}