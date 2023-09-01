package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.adapters.PostAdapter
import com.example.test2.api.ApiService
import com.example.test2.api.ServiceGenerator
import com.example.test2.data.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide the system UI elements (status bar and action bar)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        // Create a Retrofit service instance
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

        // Make an API call to get data
        val call = serviceGenerator.getPosts()

        call.enqueue(object : Callback<MutableList<DataModel>>{
            override fun onResponse(
                call: Call<MutableList<DataModel>>,
                response: Response<MutableList<DataModel>>
            ) {
                if (response.isSuccessful) {
                    // Set up RecyclerView with data using an adapter
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = PostAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<DataModel>>, t: Throwable) {
                t.printStackTrace()
                // Handle API error
                Log.e("API error", t.message.toString())
            }
        })
    }
}