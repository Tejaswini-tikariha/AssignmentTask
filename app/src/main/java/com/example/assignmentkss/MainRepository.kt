package com.example.assignmentkss

import android.util.Log

class MainRepository(private val apiService: ApiService) {
    suspend fun fetchItems(): List<ListDataModel> {
        val response = apiService.fetchItems()
        Log.d("#tttt1", response.toString()) // Logs the entire response
        return response.StockDataList
    }
}