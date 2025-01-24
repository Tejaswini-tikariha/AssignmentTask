package com.example.assignmentkss.data

import retrofit2.http.GET

interface ApiService {
    @GET("v1/39bc7786-3c3f-42c9-b815-a0ce7a6df9c7")
    suspend fun fetchItems(): ItemResponse
}