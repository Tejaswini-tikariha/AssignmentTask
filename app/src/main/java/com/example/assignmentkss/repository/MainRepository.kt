package com.example.assignmentkss.repository

import android.util.Log
import com.example.assignmentkss.data.ApiService
import com.example.assignmentkss.data.ListDataModel

class MainRepository(private val apiService: ApiService) {
    suspend fun fetchItems(): List<ListDataModel> {
        val response = apiService.fetchItems()
        Log.d("#tttt1", response.toString()) // Logs the entire response
        return response.StockDataList
    }
}