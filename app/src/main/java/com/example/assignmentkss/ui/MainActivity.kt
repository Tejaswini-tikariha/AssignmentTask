package com.example.assignmentkss.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentkss.data.ApiService
import com.example.assignmentkss.viewModel.ItemViewModelFactory
import com.example.assignmentkss.viewModel.MainViewModel
import com.example.assignmentkss.R
import com.example.assignmentkss.databinding.ActivityMainBinding
import com.example.assignmentkss.repository.MainRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.pink)

        val apiService = Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val repository = MainRepository(apiService)
        val factory = ItemViewModelFactory(repository)
        val viewModel: MainViewModel by viewModels { factory }

        binding.listRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.items.observe(this) { items ->
            binding.listRecyclerView.adapter = ListItemAdapter(items)
        }

        viewModel.error.observe(this) { error ->
            error?.let {
                // Show an error message (e.g., Toast)
            }
        }
    }
}