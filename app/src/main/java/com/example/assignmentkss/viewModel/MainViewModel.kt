package com.example.assignmentkss.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.assignmentkss.data.ListDataModel
import com.example.assignmentkss.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    private val _items = MutableLiveData<List<ListDataModel>>()
    val items: LiveData<List<ListDataModel>> = _items

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val response = repository.fetchItems()
                Log.d("#ttttt", "$response")
                _items.value = response
            } catch (e: Exception) {
                Log.d("#ttttt", "${e.message}")
                _error.value = e.message
            }
        }
    }
}

class ItemViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}