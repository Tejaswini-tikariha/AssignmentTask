package com.example.assignmentkss

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentkss.databinding.ActivityMainBinding
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