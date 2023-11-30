package com.toko.anugrah.data

import com.toko.anugrah.network.AnugrahApiService
import com.toko.anugrah.network.Product
import com.toko.anugrah.network.User
import kotlinx.coroutines.flow.Flow

interface AnugrahApiRepository {
    fun getAllUser(): Flow<List<User>>
}

class NetworkAnugrahApiRepository(private val anugrahApiService: AnugrahApiService):AnugrahApiRepository{
    override fun getAllUser(): Flow<List<User>> = anugrahApiService.getAllUser()
}